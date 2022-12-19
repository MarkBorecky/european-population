const express = require('express');
var cors = require('cors');

const app = express();
app.use(express.json());
app.use(cors());
const port = 3001;

const countries = [
  {
    name: 'Hungary',
    code: 'HUN',
    flag: '\uD83C\uDDED\uD83C\uDDFA',
    population: 9749763,
  },
  {
    name: 'Croatia',
    code: 'HRV',
    flag: '\uD83C\uDDED\uD83C\uDDF7',
    population: 4047200,
  },
  {
    name: 'Sweden',
    code: 'SWE',
    flag: '\uD83C\uDDF8\uD83C\uDDEA',
    population: 10353442,
  },
  {
    name: 'Spain',
    code: 'ESP',
    flag: '\uD83C\uDDEA\uD83C\uDDF8',
    population: 47351567,
  },
  {
    name: 'Netherlands',
    code: 'NLD',
    flag: '\uD83C\uDDF3\uD83C\uDDF1',
    population: 16655799,
  },
  {
    name: 'Luxembourg',
    code: 'LUX',
    flag: '\uD83C\uDDF1\uD83C\uDDFA',
    population: 632275,
  },
  {
    name: 'Belgium',
    code: 'BEL',
    flag: '\uD83C\uDDE7\uD83C\uDDEA',
    population: 11555997,
  },
  {
    name: 'Germany',
    code: 'DEU',
    flag: '\uD83C\uDDE9\uD83C\uDDEA',
    population: 83240525,
  },
  {
    name: 'Slovenia',
    code: 'SVN',
    flag: '\uD83C\uDDF8\uD83C\uDDEE',
    population: 2100126,
  },
  {
    name: 'Malta',
    code: 'MLT',
    flag: '\uD83C\uDDF2\uD83C\uDDF9',
    population: 525285,
  },
  {
    name: 'Finland',
    code: 'FIN',
    flag: '\uD83C\uDDEB\uD83C\uDDEE',
    population: 5530719,
  },
  {
    name: 'Ireland',
    code: 'IRL',
    flag: '\uD83C\uDDEE\uD83C\uDDEA',
    population: 4994724,
  },
  {
    name: 'Denmark',
    code: 'DNK',
    flag: '\uD83C\uDDE9\uD83C\uDDF0',
    population: 5831404,
  },
  {
    name: 'Bulgaria',
    code: 'BGR',
    flag: '\uD83C\uDDE7\uD83C\uDDEC',
    population: 6927288,
  },
  {
    name: 'Poland',
    code: 'POL',
    flag: '\uD83C\uDDF5\uD83C\uDDF1',
    population: 37950802,
  },
  {
    name: 'Latvia',
    code: 'LVA',
    flag: '\uD83C\uDDF1\uD83C\uDDFB',
    population: 1901548,
  },
  {
    name: 'Austria',
    code: 'AUT',
    flag: '\uD83C\uDDE6\uD83C\uDDF9',
    population: 8917205,
  },
  {
    name: 'Estonia',
    code: 'EST',
    flag: '\uD83C\uDDEA\uD83C\uDDEA',
    population: 1331057,
  },
  {
    name: 'Portugal',
    code: 'PRT',
    flag: '\uD83C\uDDF5\uD83C\uDDF9',
    population: 10305564,
  },
  {
    name: 'Cyprus',
    code: 'CYP',
    flag: '\uD83C\uDDE8\uD83C\uDDFE',
    population: 1207361,
  },
  {
    name: 'Czechia',
    code: 'CZE',
    flag: '\uD83C\uDDE8\uD83C\uDDFF',
    population: 10698896,
  },
  {
    name: 'Italy',
    code: 'ITA',
    flag: '\uD83C\uDDEE\uD83C\uDDF9',
    population: 59554023,
  },
  {
    name: 'Greece',
    code: 'GRC',
    flag: '\uD83C\uDDEC\uD83C\uDDF7',
    population: 10715549,
  },
  {
    name: 'Lithuania',
    code: 'LTU',
    flag: '\uD83C\uDDF1\uD83C\uDDF9',
    population: 2794700,
  },
  {
    name: 'Slovakia',
    code: 'SVK',
    flag: '\uD83C\uDDF8\uD83C\uDDF0',
    population: 5458827,
  },
  {
    name: 'Romania',
    code: 'ROU',
    flag: '\uD83C\uDDF7\uD83C\uDDF4',
    population: 19286123,
  },
  {
    name: 'France',
    code: 'FRA',
    flag: '\uD83C\uDDEB\uD83C\uDDF7',
    population: 67391582,
  },
  {
    name: 'Fiction',
    code: 'FIC',
    flag: null,
    population: 10000000,
  },
];

const cities = [
  {
    countrycode: 'HUN',
    name: 'Budapest',
    capital: true,
    population: 1706851,
  },
  {
    countrycode: 'HRV',
    name: 'Zagreb',
    capital: true,
    population: 769944,
  },
  {
    countrycode: 'SWE',
    name: 'Stockholm',
    capital: true,
    population: 978770,
  },
  {
    countrycode: 'SWE',
    name: 'Gothenburg',
    population: 587549,
  },
  {
    countrycode: 'SWE',
    name: 'Malmö',
    population: 351749,
  },
  {
    countrycode: 'ESP',
    name: 'Madrid',
    capital: true,
    population: 3305408,
  },
  {
    countrycode: 'ESP',
    name: 'Barcelona',
    population: 1636732,
  },
  {
    countrycode: 'ESP',
    name: 'Valencia',
    population: 789744,
  },
  {
    countrycode: 'ESP',
    name: 'Seville',
    population: 684234,
  },
  {
    countrycode: 'ESP',
    name: 'Zaragoza',
    population: 675301,
  },
  {
    countrycode: 'ESP',
    name: 'Málaga',
    population: 577405,
  },
  {
    countrycode: 'ESP',
    name: 'Murcia',
    population: 460349,
  },
  {
    countrycode: 'ESP',
    name: 'Palma de Mallorca',
    population: 419366,
  },
  {
    countrycode: 'ESP',
    name: 'Las Palmas',
    population: 378675,
  },
  {
    countrycode: 'ESP',
    name: 'Bilbao',
    population: 346405,
  },
  {
    countrycode: 'ESP',
    name: 'Alicante',
    population: 337304,
  },
  {
    countrycode: 'ESP',
    name: 'Córdoba',
    population: 322071,
  },
  {
    countrycode: 'NLD',
    name: 'Amsterdam',
    capital: true,
    population: 905234,
  },
  {
    countrycode: 'NLD',
    name: 'Rotterdam',
    population: 655418,
  },
  {
    countrycode: 'NLD',
    name: 'The Hague',
    population: 553277,
  },
  {
    countrycode: 'NLD',
    name: 'Utrecht',
    population: 361966,
  },
  {
    countrycode: 'LUX',
    name: 'Luxembourg',
    capital: true,
    population: 128514,
  },
  {
    countrycode: 'BEL',
    name: 'Antwerp',
    capital: true,
    population: 528903,
  },
  {
    countrycode: 'DEU',
    name: 'Berlin',
    capital: true,
    population: 3677472,
  },
  {
    countrycode: 'DEU',
    name: 'Hamburg',
    population: 1853935,
  },
  {
    countrycode: 'DEU',
    name: 'Munich',
    population: 1487708,
  },
  {
    countrycode: 'DEU',
    name: 'Cologne',
    population: 1073096,
  },
  {
    countrycode: 'DEU',
    name: 'Frankfurt am Main',
    population: 759224,
  },
  {
    countrycode: 'DEU',
    name: 'Stuttgart',
    population: 626275,
  },
  {
    countrycode: 'DEU',
    name: 'Düsseldorf',
    population: 619477,
  },
  {
    countrycode: 'DEU',
    name: 'Leipzig',
    population: 601866,
  },
  {
    countrycode: 'DEU',
    name: 'Dortmund',
    population: 586852,
  },
  {
    countrycode: 'DEU',
    name: 'Essen',
    population: 579432,
  },
  {
    countrycode: 'DEU',
    name: 'Bremen',
    population: 563290,
  },
  {
    countrycode: 'DEU',
    name: 'Dresden',
    population: 555351,
  },
  {
    countrycode: 'DEU',
    name: 'Hanover',
    population: 535932,
  },
  {
    countrycode: 'DEU',
    name: 'Nuremberg',
    population: 510632,
  },
  {
    countrycode: 'DEU',
    name: 'Duisburg',
    population: 495152,
  },
  {
    countrycode: 'DEU',
    name: 'Bochum',
    population: 363441,
  },
  {
    countrycode: 'DEU',
    name: 'Wuppertal',
    population: 354572,
  },
  {
    countrycode: 'DEU',
    name: 'Bielefeld',
    population: 334002,
  },
  {
    countrycode: 'DEU',
    name: 'Bonn',
    population: 331885,
  },
  {
    countrycode: 'DEU',
    name: 'Münster',
    population: 317713,
  },
  {
    countrycode: 'DEU',
    name: 'Mannheim',
    population: 311831,
  },
  {
    countrycode: 'DEU',
    name: 'Karlsruhe',
    population: 306502,
  },
  {
    countrycode: 'SVN',
    name: 'Ljubljana',
    capital: true,
    population: 279631,
  },
  {
    countrycode: 'MLT',
    name: 'Valletta',
    capital: true,
    population: 5730,
  },
  {
    countrycode: 'FIN',
    name: 'Helsinki',
    capital: true,
    population: 658864,
  },
  {
    countrycode: 'FIN',
    name: 'Espoo',
    population: 300748,
  },
  {
    countrycode: 'FIN',
    name: 'Tampere',
    population: 245027,
  },
  {
    countrycode: 'FIN',
    name: 'Vantaa',
    population: 241061,
  },
  {
    countrycode: 'FIN',
    name: 'Oulu',
    population: 209934,
  },
  {
    countrycode: 'FIN',
    name: 'Turku',
    population: 195047,
  },
  {
    countrycode: 'IRL',
    name: 'Dublin',
    capital: true,
    population: 554554,
  },
  {
    countrycode: 'DNK',
    name: 'Copenhagen',
    capital: true,
    population: 644431,
  },
  {
    countrycode: 'DNK',
    name: 'Aarhus',
    population: 355238,
  },
  {
    countrycode: 'BGR',
    name: 'Sofia',
    capital: true,
    population: 1307439,
  },
  {
    countrycode: 'BGR',
    name: 'Plovdiv',
    population: 343070,
  },
  {
    countrycode: 'BGR',
    name: 'Varna',
    population: 341737,
  },
  {
    countrycode: 'POL',
    name: 'Warsaw',
    capital: true,
    population: 1863056,
  },
  {
    countrycode: 'POL',
    name: 'Kraków',
    population: 802583,
  },
  {
    countrycode: 'POL',
    name: 'Wrocław',
    population: 674312,
  },
  {
    countrycode: 'POL',
    name: 'Łódź',
    population: 664860,
  },
  {
    countrycode: 'POL',
    name: 'Poznań',
    population: 545073,
  },
  {
    countrycode: 'POL',
    name: 'Gdańsk',
    population: 486271,
  },
  {
    countrycode: 'POL',
    name: 'Szczecin',
    population: 394482,
  },
  {
    countrycode: 'POL',
    name: 'Bydgoszcz',
    population: 334026,
  },
  {
    countrycode: 'POL',
    name: 'Lublin',
    population: 332852,
  },
  {
    countrycode: 'LVA',
    name: 'Riga',
    capital: true,
    population: 611824,
  },
  {
    countrycode: 'AUT',
    name: 'Vienna',
    capital: true,
    population: 1962779,
  },
  {
    countrycode: 'EST',
    name: 'Tallinn',
    capital: true,
    population: 437811,
  },
  {
    countrycode: 'PRT',
    name: 'Lisbon',
    capital: true,
    population: 545923,
  },
  {
    countrycode: 'PRT',
    name: 'Sintra',
    population: 385654,
  },
  {
    countrycode: 'PRT',
    name: 'Vila Nova de Gaia',
    population: 303854,
  },
  {
    countrycode: 'CYP',
    name: 'Nicosia',
    capital: true,
    population: 116392,
  },
  {
    countrycode: 'CYP',
    name: 'Limassol',
    population: null,
  },
  {
    countrycode: 'CZE',
    name: 'Prague',
    capital: true,
    population: 1275406,
  },
  {
    countrycode: 'CZE',
    name: 'Brno',
    population: 379466,
  },
  {
    countrycode: 'ITA',
    name: 'Rome',
    capital: true,
    population: 2761632,
  },
  {
    countrycode: 'ITA',
    name: 'Milan',
    population: 1371498,
  },
  {
    countrycode: 'ITA',
    name: 'Naples',
    population: 914758,
  },
  {
    countrycode: 'ITA',
    name: 'Turin',
    population: 848885,
  },
  {
    countrycode: 'ITA',
    name: 'Palermo',
    population: 630828,
  },
  {
    countrycode: 'ITA',
    name: 'Genoa',
    population: 560688,
  },
  {
    countrycode: 'ITA',
    name: 'Bologna',
    population: 392203,
  },
  {
    countrycode: 'ITA',
    name: 'Florence',
    population: 367150,
  },
  {
    countrycode: 'ITA',
    name: 'Bari',
    population: 316140,
  },
  {
    countrycode: 'GRC',
    name: 'Athens',
    capital: true,
    population: 637798,
  },
  {
    countrycode: 'GRC',
    name: 'Thessaloniki',
    population: 317778,
  },
  {
    countrycode: 'LTU',
    name: 'Vilnius',
    capital: true,
    population: 576195,
  },
  {
    countrycode: 'LTU',
    name: 'Kaunas',
    population: 301300,
  },
  {
    countrycode: 'SVK',
    name: 'Bratislava',
    capital: true,
    population: 475044,
  },
  {
    countrycode: 'ROU',
    name: 'Bucharest',
    capital: true,
    population: 2161347,
  },
  {
    countrycode: 'ROU',
    name: 'Iași',
    population: 391024,
  },
  {
    countrycode: 'ROU',
    name: 'Cluj-Napoca',
    population: 328316,
  },
  {
    countrycode: 'ROU',
    name: 'Timișoara',
    population: 318296,
  },
  {
    countrycode: 'ROU',
    name: 'Constanța',
    population: 306607,
  },
  {
    countrycode: 'ROU',
    name: 'Galați',
    population: 304957,
  },
  {
    countrycode: 'FRA',
    name: 'Paris',
    capital: true,
    population: 2139907,
  },
  {
    countrycode: 'FRA',
    name: 'Marseille',
    population: 870731,
  },
  {
    countrycode: 'FRA',
    name: 'Lyon',
    population: 522969,
  },
  {
    countrycode: 'FRA',
    name: 'Toulouse',
    population: 493465,
  },
  {
    countrycode: 'FRA',
    name: 'Nice',
    population: 342669,
  },
  {
    countrycode: 'FRA',
    name: 'Nantes',
    population: 318808,
  },
];

app.get('/', (req, res) => {
  res.send('Available endpoints: GET /countries, GET /cities?country={CODE}');
});

app.get('/countries', async (req, res) => {
  res.send(countries);
});

app.get('/cities', async (req, res) => {
  const rawCodes = req.query.country;
  const codes = typeof rawCodes === 'string' ? [rawCodes] : rawCodes || [];
  res.send(cities.filter((city) => codes.includes(city.countrycode)));
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
