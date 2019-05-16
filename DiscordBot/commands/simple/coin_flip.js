const commando = require('discord.js-commando');

class CoinFlipCommand extends commando.Command {
    constructor(client) {
        super(client, {
            name: 'flip',
            group: 'simple',
            memberName: 'flip',
            description: 'Flips a coin which will return heads or tails'
        });
    }

    async run(message, args) {
        //picks a random number (float) and rounds it down
        var chance = Math.floor(Math.random() * 2);
        if(chance == 0) {
            message.reply("Heads");
        }
        else {
            message.reply("Tails");
        }
    }
}

//lets index.js know the command exists
module.exports = CoinFlipCommand;