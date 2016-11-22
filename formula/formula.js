let jsonFileLoader = require('jsonfile');
const _ = require('underscore');
let imageProcessingResult = jsonFileLoader.readFileSync('./image-processing.json');
let expSysResult = jsonFileLoader.readFileSync('./exp-sys.json');

let result = _.clone(expSysResult, true);

_.map(imageProcessingResult, (res) => {
  let pos = _.chain(result).pluck('name').indexOf(res.name).value();
  if(pos === -1 && res.percentage > 85) { //does not exist in primary and very accurate.
    res.percentage = res.percentage/2.0; //half of its percentage.
    result.push(res); // add to primary result;
  } else if (pos >= 0 && res.percentage < 45) { // exist but inaccurate.
    result.slice(pos, 1); // remove it from primary result
  } else if (pos >= 0 && res.percentage >= 45) {
    result[pos].percentage = (result[pos].percentage + res.percentage)/2.0;
  }
});

const compare = (a, b) => {
  return b.percentage - a.percentage;
};

console.log(result.sort(compare));
