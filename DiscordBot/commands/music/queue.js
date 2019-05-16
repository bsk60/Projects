const commando = require('discord.js-commando');
const YTDL = require('ytdl-core');

class QueueCommand extends commando.Command {
    constructor(client) 
    {
        super(client, 
        {
            name: 'queue',
            group: 'music',
            memberName: 'queue',
            description: 'Bot joins voice channel of the person who typed the command and plays youtube link'
        });
    }

    async run(message, args) 
    {
        if(message.member.voiceChannel) 
        {
            if(!message.guild.voiceConnection) 
            {
                //checks to see if queue exists with server id
                if(!servers[message.guild.id])
                {
                    servers[message.guild.id] = {queue: []}
                }
                message.member.voiceChannel.join()
                    .then(connection =>{
                        var server = servers[message.guild.id];
                        if(!server.queue) {
                            message.reply("The queue is empty");
                        }
                        else
                        {
                        YTDL(server.queue[0]).on('info', (info) => {
                            info.title;
                        })
                        //console.log(holder);
                        Play(connection, message);
                        //message.reply("The queue is: " + servers[message.guild.id]);
                        }
                    })
                    /*
                        message.reply("Successfully joined the channel");
                    */
            }
        }
        else 
        {
            message.reply("You must be in a voice channel for this command");
        }
    }
}

//lets index.js know the command exists
module.exports = QueueCommand;