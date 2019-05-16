const commando = require('discord.js-commando');
const YTDL = require('ytdl-core');

var servers = {};

function Play(connection, message)
{
    var server = servers[message.guild.id];
    server.dispatcher = connection.playStream(YTDL(server.queue[0], {filter: "audioonly"}));
    server.queue.shift();
    server.dispatcher.on("end", function(){
        if(server.queue[0])
        {
            Play(connection,message);
        }
        else 
        {
            connection.disconnect();
        }
    });
}

class PlayMusicCommand extends commando.Command {
    constructor(client) 
    {
        super(client, 
        {
            name: 'play',
            group: 'music',
            memberName: 'play',
            description: 'Bot joins voice channel of the person who typed the command and plays youtube link'
        });
    }

    async run(message, args) 
    {
        if(!args[1]) {
            message.channel.sendMessage("Please provide a link");
            return;
        }
        if(message.member.voiceChannel) 
        {
            if(!message.guild.voiceConnection) 
            {
                //checks to see if queue exists with server id
                if(!servers[message.guild.id])
                {
                    servers[message.guild.id] = 
                    {
                        queue: []
                    }
                }
                message.member.voiceChannel.join()
                    .then(connection =>{
                        var server = servers[message.guild.id];
                        server.queue.push(args);
                        console.log(server);
                        YTDL(server.queue[0]).on('info', (info) => {
                            info.title;
                            console.log(info.title);
                        })
                        Play(connection, message);
                    })
            }
        }
        else 
        {
            message.reply("You must be in a voice channel for this command");
        }
    }
}

//lets index.js know the command exists
module.exports = PlayMusicCommand;
