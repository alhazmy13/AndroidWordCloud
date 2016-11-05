var loadCloud = function(isAndroid, element, userChosenFontFace, data,parentWidth, parentHeight) {

  console.log('parentWidth: ' + parentWidth);
  console.log('parentHeight: ' + parentHeight);

var test  = $.parseJSON(data);
var t = test.map(function(d) {  return {text: d.word, size: d.size, color: d.color};});
 console.log(t);

    var fill = d3.scale.category20();
    var layout = d3.layout.cloud()
        .size([parentHeight, parentWidth ])
       .words(t)
        .padding(5)
        .rotate(function() { return ~~(Math.random() * 2) * 90; })
        .font(userChosenFontFace)
        .fontSize(function(d) { return d.size; })
        .on("end", draw);
    layout.start();
    function draw(words) {
      d3.select("body").append("svg")
          .attr("width", layout.size()[0])
          .attr("height", layout.size()[1])
        .append("g")
          .attr("transform", "translate(" + layout.size()[0] / 2 + "," + layout.size()[1] / 2 + ")")
        .selectAll("text")
          .data(words)
        .enter().append("text")
          .style("font-size", function(d) { return d.size + "px"; })
          .style("font-family", userChosenFontFace)
          .style("fill", function(d, i) {
            if(new String(d.color).valueOf() == new String("0").valueOf()){
              console.log(d.color);
               return i ;
               } else{
                return d.color;
                }
          })
          .attr("text-anchor", "middle")
          .attr("transform", function(d) {
            return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
          })
          .text(function(d) { return d.text; });
    }
}

var isAndroid = false;

// Parameters to pass. If isAndroid is true, use our Android JS functions.
// Otherwise, use our overrides.
var cloudFont =  window.jsinterface.getCloudFont() ;
var cloudText =  window.jsinterface.getCloudString() ;
var parentWidth = window.jsinterface.getParentWidth();
var parentHeight = window.jsinterface.getParentHeight();

loadCloud(isAndroid, $('#cloud'), cloudFont, cloudText,parentWidth,parentHeight);
