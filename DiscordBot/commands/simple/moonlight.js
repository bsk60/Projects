const e7Database = "https://epicsevendb-apiserver.herokuapp.com/api/";
const assets = "https://assets.epicsevendb.com/";
const commando = require('discord.js-commando');

var jsdom = require("jsdom");
const { JSDOM } = jsdom;
const { window } = new JSDOM();
const { document } = (new JSDOM('')).window;
global.document = document;
var $ = jQuery = require('jquery')(window);

var types = 
{
    hero: {loaded: false},
    artifact: {loaded: false}
}

function storeTypes() 
{
    cacheStuff("hero");
    cacheStuff("artifact");
}

function cacheStuff(type) {
    $.get(e7Database + type, function(data, status) {
        if(status == "success")
        {
            var results = data.results;
            $.each(results, function(i) {
                types[type][results[i].fileId] = results[i];
            });
            types[type].loaded = true;
        }
        else
        {
            console.log("unable to establish connection");
        }
    });
}
storeTypes();

//moonlight summon only
function Roll(pool, id)
{
    var type = 'hero';
    var summonType = 'MoonlightSummon'
    var moonlightPull = getRandomInt(100) + 1;
        //3* hero
        if(moonlightPull <= 70)
        {
            var currentPool = Pool[summonType][type]['3'];
            var received = getRandomInt(16);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".png";

            return summoned + image;
        } 
        //4* hero
        else if(moonlightPull > 70 && moonlightPull <= 98) 
        {
            var currentPool = Pool[summonType][type]['4'];
            var received = getRandomInt(17);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".png";

            return summoned + image;
        }
        //5* hero
        else 
        {
            var currentPool = Pool[summonType][type]['5'];
            var received = getRandomInt(9);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".png";

            return summoned + image;
        }
    }

function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}
class MoonlightCommand extends commando.Command {
    constructor(client) {
        super(client, {
            name: 'ml',
            group: 'simple',
            memberName: 'moonlight',
            description: 'Epic Seven Summon Simulator'
        });
    }

    async run(message, args) 
    {
            var acquired = 0;
            message.reply(Roll(Pool, acquired));
    }
}

var Pool = {
    MoonlightSummon: {
        hero: {
            5: [
                "arbiter-vildred",
                "dark-corvus",
                "judge-kise",
                "maid-chloe",
                "martial-artist-ken",
                "ruele-of-light",
                "silver-blade-aramintha",
                "specimen-sez",
                "specter-tenebria"
            ],
            4: [
                "assassin-cartuja",
                "assassin-cidd",
                "assassin-coli",
                "auxiliary-lots",
                "blaze-dingo",
                "blood-blade-karin",
                "celestial-mercedes",
                "challenger-dominiel",
                "crimson-armin",
                "fighter-maya",
                "general-purrgis",
                "guider-aither",
                "kitty-clarissa",
                "shadow-rose",
                "shooting-star-achates",
                "wanderer-silk",
                "watcher-schuri"
            ],
            3: [
                "arowell",
                "celeste",
                "church-of-ilryos-axe",
                "doris",
                "elson",
                "gloomyrain",
                "gunther",
                "hurado",
                "lorina",
                "mirsa",
                "otillie",
                "pyllis",
                "requiemroar",
                "rikoris",
                "sven",
                "wanda" 
            ]
        },
    }
}
module.exports = MoonlightCommand;