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

    //Focuses Cursor to start type Duty Title
    $('#NewDutyModal').on('shown.bs.modal', function () {
        $('#DutyName').focus();
    });

    //Submits the New Duty Item
    $(".submit-new-duty").click(function() {
        submitDuty();
    });

    function submitDuty() {
        var dutyName = $("#DutyName").val();
        var dutyDesc = $("#DutyDesc").val();
        var targetClass = $("#TargetedClass").val();
        var fineAmount = $("#FineAmount").val();
        var active = $("#Active").val();

        // The Mapping on the left needs to be
        // representative of what /HM/NewDuty is looking for
        $.ajax({
            type:"POST",
            url: "/HM/NewDuty",
            data:
            {
                DutyName: dutyName,
                DutyDesc: dutyDesc,
                TargetedClass: targetClass,
                FineAmount: fineAmount,
                Active: active
            },
            success: function(msg) {
                console.log("Success Sending Ajax For New Duty. Message returned was: " + msg);
            }
        });

        //addToDutyTable(dutyName, dutyDesc, targetClass, fineAmount, active);

        $(".cancel-new-duty").click(); //To close modal and clear data
    }

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