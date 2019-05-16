const e7Database = "https://epicsevendb-apiserver.herokuapp.com/api/";
const assets = "https://assets.epicsevendb.com/";
const commando = require('discord.js-commando');
const Pool = module.Pool;

//creates virtual window in order to use jquery with node
var jsdom = require("jsdom");
const { JSDOM } = jsdom;
const { window } = new JSDOM();
const { document } = (new JSDOM('')).window;
global.document = document;
var $ = jQuery = require('jquery')(window);

//type of summons one can get
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

//grabbing data from the api and storing them
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

//normal summon only
function Roll(pool, id)
{
    var type = '';
    var summonType = 'NormalSummon'
    var HeroOrArtifact = getRandomInt(100) + 1;
    //hero
    if(HeroOrArtifact < 47)
    {
        type = 'hero';
        var Rarity = getRandomInt(47) + 1;
        //3* hero
        if(Rarity <= 41)
        {
            var currentPool = Pool[summonType][type]['3'];
            var received = getRandomInt(25);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".png";

            return summoned + image;
        } 
        //4* hero
        else if(Rarity > 41 && Rarity <= 46) 
        {
            var currentPool = Pool[summonType][type]['4'];
            var received = getRandomInt(23);
            var summoned = currentPool[received];
            

            return summoned + image;
        }
        //5* hero
        else 
        {
            var currentPool = Pool[summonType][type]['5'];
            var received = getRandomInt(25);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".png";

            return summoned + image;
        }
    }
    //artifact
    else
    {
        type = 'artifact';
        var Rarity = getRandomInt(53) + 1;
        //3* artifact
        if(Rarity <= 45) 
        {
            var currentPool = Pool[summonType][type]['3'];
            var received = getRandomInt(22);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".jpg";

            return summoned + image;
        }
        //4* artifact
        else if(Rarity > 45 && Rarity <= 51)
        {
            var currentPool = Pool[summonType][type]['4'];
            var received = getRandomInt(18);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".jpg";

            return summoned + image;
        }
        //5* artifact
        else 
        {
            var currentPool = Pool[summonType][type]['5'];
            var received = getRandomInt(21);
            var summoned = currentPool[received];
            var image = assets + type + "/" + summoned + "/small" + ".jpg";

            return summoned + image;
        }
    }

}
//simple random number generator
function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

class SummonCommand extends commando.Command {
    constructor(client) {
        super(client, {
            name: 'summon',
            group: 'simple',
            memberName: 'summon',
            description: 'Epic Seven Summon Simulator'
        });
    }

    async run(message, args) 
    {
            var acquired = 0;
            message.reply(Roll(acquired));
    }
}

//unable to be accessed in separate file even though it's global
/*
var Pool = {
    NormalSummon: {
        hero: {
            5: [
                "aramintha",
                "baal-sezan",
                "basar",
                "bellona",
                "cecilia",
                "charlotte",
                "chloe",
                "destina",
                "haste",
                "iseria",
                "kayron",
                "ken",
                "lidica",
                "kise",
                "krau",
                "ludwig",
                "ravi",
                "sez",
                "sigret",
                "tamarinne",
                "tenebria",
                "tywin",
                "vildred",
                "violet",
                "yufine"
            ],
            4: [
                "achates",
                "angelica",
                "armin",
                "cartuja",
                "cidd",
                "clarissa",
                "coli",
                "corvus",
                "crozet",
                "dingo",
                "dominiel",
                "karin",
                "leo",
                "lots",
                "maya",
                "purrgis",
                "rin",
                "romann",
                "rose",
                "schuri",
                "silk",
                "surin",
                "zerato"
            ],
            3: [
                "adlay",
                "aither",
                "alexa",
                "azalea",
                "butcher-corps-inquisitor",
                "carmainerose",
                "carrot",
                "enott",
                "hazel",
                "helga",
                "jecht",
                "jena",
                "judith",
                "kiris",
                "kluri",
                "mistychain",
                "montmorancy",
                "mucacha",
                "nemunas",
                "pearlhorizon",
                "rima",
                "roozid",
                "taranor-guard",
                "taranor-royal-guard",
                "tieria"
            ]
        },
        artifact: {
            5: [
                "abyssal-crown",
                "alexas-basket",
                "bloodstone",
                "celestine",
                "durandal",
                "elbris-ritual-sword",
                "eticas-scepter",
                "holy-sacrifice",
                "idols-cheer",
                "iron-fan",
                "noble-oath",
                "purple-talisman",
                "rhianna-luciella",
                "rod-of-amaryllis",
                "shimadra-staff",
                "sigurd-scythe",
                "song-of-stars",
                "sword-of-judgement",
                "time-matter",
                "uberiuss-tooth",
                "wind-rider"
            ],
            4: [
                "adamant-shield",
                "aurius",
                "dust-devil",
                "els-fist",
                "elyhas-knife",
                "hell-cutter",
                "hilag-lance",
                "infinity-basket",
                "kaladra",
                "magarahas-tome",
                "moonlight-dreamblade",
                "rosa-hargana",
                "sashe-ithanes",
                "sira-ren",
                "strak-gauntlet",
                "tagehels-ancient-book",
                "waters-origin",
                "wondrous-potion-vial"
            ],
            3: [
                "alsacian-spear",
                "ancient-sheath",
                "aqua-rose",
                "ascending-axe",
                "atmas-portal",
                "butterfly-mandolin",
                "cursed-compass",
                "daydream-joker",
                "devils-brand",
                "egg-of-delusion",
                "envoys-pipe",
                "exorcists-tonfa",
                "forest-totem",
                "goblins-lamp",
                "grail-of-blood",
                "labyrinth-cube",
                "mighty-yaksha",
                "oath-key",
                "prophetic-candlestick",
                "ranons-memorandum",
                "sword-of-the-morning",
                "timeless-anchor"
            ]
        }
    }
}
*/
module.exports = SummonCommand;