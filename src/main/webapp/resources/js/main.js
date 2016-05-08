$(function () {

    // Well done!!! Working code !
    $(document).ready(function () {
        var statistics = document.getElementById('statistics-array').getAttribute('value');
        var statisticsArr = JSON.parse(statistics);
        var data = {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri'],
            series: [statisticsArr]
        };
        new Chartist.Line('.ct-chart', data);
    });


    $(document).on("click", "#href-update-statistics", function (event) {
        event.preventDefault();
        $.get("/updatestatistics", function (responseText) {
            /*var stat = data;*/
            /*console.log(responseText);*/
            /*console.log(stat[0]);*/
            new Chartist.Line('.ct-chart', JSON.parse(responseText));
        });
    });

/*    $(document).on("click", "#update-button", function (event) {
        $.get("/updateweather", function (responseText) {
            document.getElementById('temp-weather').innerText = responseText;
        });
    });*/
        /*        $.get("/updatestatistics", function (responseText) {
         new Chartist.Line('.ct-chart', data);
         document.getElementsByClassName(".ct-chart").innerText = responseText;
         });
         new Chartist.Line('.ct-chart', dataNew);*/



    /*    $(document).on("click", "#update-button", function (event) {
     $.get("/updateweather", function (responseText) {
     document.getElementById('temp-weather').innerText = responseText;
     });
     });*/

});
