const commando = require('discord.js-commando');
const discord = require('discord.js');

class EightBallCommand extends commando.Command {
    constructor(client) {
        super(client, {
            name: '8ball',
            group: 'simple',
            memberName: '8ball',
            description: 'Simple 8 ball'
        });
    }

    async run(message, args) 
    {
        var responses = ['Very Likely', 'Do not even think about it', 'Very unlikely', 'For sure', 'Definitely not', 'Probably']
        var random = Math.floor(Math.random() * responses.length);
        message.reply(responses[random]);
    }
}

module.exports = EightBallCommand;