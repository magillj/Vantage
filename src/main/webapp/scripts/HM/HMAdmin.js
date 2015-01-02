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

    // The Mapping on the left needs to be
    // representative of what /HM/NewDuty is looking for
    $(".submit-new-duty").click(function() {
        $.ajax({
            url: "/HM/NewDuty",
            type:'POST',
            data:
            {
                DutyName: $("#DutyName").val(),
                DutyDesc: $("#DutyDesc").val(),
                TargetedClass: $("#TargetedClass").val(),
                FineAmount: $("#FineAmount").val(),
                Active: $("#Active").val()
            },
            success: function(msg)
            {
                console.log("Success Sending Ajax For New Duty. Message returned was: " + msg);
            }
        });
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