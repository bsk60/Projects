const commando = require('discord.js-commando');

class LeaveChannelCommand extends commando.Command {
    constructor(client) {
        super(client, 
        {
            name: 'leave',
            group: 'music',
            memberName: 'leave',
            description: 'Bot leaves voice channel of the person who typed the command'
        });
    }

    async run(message, args) {
       if(message.guild.voiceConnection) 
       {
            message.guild.voiceConnection.disconnect();
       }
       else
       {
            message.reply("I'm already not in a channel");
       }
    }
}

//lets index.js know the command exists
module.exports = LeaveChannelCommand;