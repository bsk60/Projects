const Discord = require('discord.js');
const Commando = require('discord.js-commando');
const YTDL = require('ytdl-core');
const bot = new Commando.Client();
const token = 'test'
const commandSymbol = ".";
var songQueue = [];

bot.login('test');
global.servers = {};
//commands 
bot.registry.registerGroup('simple', "Simple");
bot.registry.registerGroup('music', 'Music');

bot.registry.registerDefaults();
//command directory 
bot.registry.registerCommandsIn(__dirname + "/commands");

//play song (youtube link) function
function play(connection, message)
{
    var server = servers[message.guild.id];
    server.dispatcher = connection.playStream(YTDL(server.queue[0], {filter: "audioonly"}));
    //getSongTitle(message);
    server.dispatcher.on("end", function(){
        server.queue.shift();
        songQueue.titles.shift();
        if(server.queue[0])
        { 
            play(connection,message);
        }
        else connection.disconnect();
    });
}

bot.on('message', function(message)
{
    if(message.content == 'Hello')
    {
        //sends to channel without any mention
        message.channel.sendMessage('How are you doing? ' /*+ message.author*/);
        //mentions person who sent the message
        //message.reply('aylmao');
    }
    if(message.author.equals(bot.user)) return;

    if(!message.content.startsWith(commandSymbol)) return;

var args = message.content.substring(commandSymbol.length).split(" ");

//switch cases for music bot commands
switch(args[0].toLowerCase()) 
{
    case "play":
    if(!args[1])
    {
        message.channel.sendMessage("Please provide a link");
        return;
    }
    if(!message.member.voiceChannel)
    {
        message.channel.sendMessage("You must be in a voice channel");
    }
    if(!servers[message.guild.id])
    {
        servers[message.guild.id] = {queue:[]};
        songQueue = {titles:[]};
    }
    var server = servers[message.guild.id];
    server.queue.push(args[1]);
    songQueue.titles.push(args[1]);
    
    if(!message.guild.voiceConnection)
    {
        message.member.voiceChannel.join().then(function(connection) 
        {
            play(connection, message);
        });
    }
    break;

    case "skip":
        var server = servers[message.guild.id];
        if(server.dispatcher)
        {
            server.dispatcher.end();
        }
    break;

    case "stop":
        if(message.guild.voiceConnection)
        {
            message.guild.voiceConnection.disconnect();
        }
        else
        {
            message.channel.sendMessage("I'm not in a channel already");
        }
    break;

    case "song":
        var server = servers[message.guild.id];
        YTDL(server.queue[0]).on("info", function(info) {
            info.title;
            message.channel.sendMessage("The current song playing is: " + info.title);
        });
    break;

    case "pause":
        var server = servers[message.guild.id];
        server.dispatcher.pause();
    break;

    case "resume":
        var server = servers[message.guild.id];
        if(server.dispatcher.paused)
        {
            server.dispatcher.resume();
        }
        else
        {
            message.channel.sendMessage("The song is already playing");
        }
    break;

    case "queue":
        message.channel.sendMessage("The queue is: ")
        for(x = 0; x < songQueue.titles.length; x++) 
        {
            var y = x + 1;
            YTDL(songQueue.titles[x]).on("info", function(info) {
                message.channel.sendMessage(info.title);
            });
        }
    break;

    default:
    message.channel.sendMessage("That command doesn't exist");
}
});

bot.on('ready', function(){
    console.log("Bot is ready to be used");
})