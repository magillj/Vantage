/**
 *   Created by btaylor5 on 12/31/14.
 *
 *
 **/

"use strict";
$(document).ready(function(){

    var dutyInfo;



    $(".view-duties").click(function(){
        console.log("New Duty Interaction");
        loadingbar();
        getDuties();
    });

    function getDuties() {
        $.ajax({
            type: "POST",
            url: "/HM/GetDuties",
            success:
                function(data) {
                    console.log("Data: " + data);
                    dutyInfo = data;
                }
        });
    }

    function loadingbar() {
        console.log("throw that loading bar in...");
    }


});