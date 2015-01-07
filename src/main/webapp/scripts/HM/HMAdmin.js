/**
 *   Created by btaylor5 on 12/31/14.
 *
 *
 **/

"use strict";
$(document).ready(function(){

    var dutyInfo;
    var isDutySheetPopulated = false;



    $(".view-duties").click(function(){
        if (!isDutySheetPopulated) {
            loadingbar();
            getDuties();
            isDutySheetPopulated = true;
        }
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

        addToDutyTable(dutyName, dutyDesc, targetClass, fineAmount, active);

        $(".cancel-new-duty").click(); //To close modal and clear data
    }

    //Retrieves all the duties and adds it to the table
    function getDuties() {
        $.ajax({
            type: "POST",
            url: "/HM/GetDuties",
            data: 'json',
            success:
                function(data) {
                    dutyInfo = data;
                    for (var i = 0; i < data.length; i++) {
                        addToDutyTable(data[i].dutyName, data[i].dutyDesc, data[i].targetedClass, data[i].fineAmount, data[i].active);
                    }
                }
        });

    }

    function loadingbar() {
        console.log("throw that loading bar in...");
    }

    //Adds a Duty to the duty table
    function addToDutyTable(dutyName, dutyDesc, targetClass, fineAmount, active) {
        $(".duty-table").find('tbody')
            .append($('<tr>')
                .append($('<td>').text(dutyName))
                .append($('<td>').text(targetClass))
                .append($('<td>').text("$" + fineAmount))
                .append($('<td>').append(editDutyButton()))
        );
    }

    function editDutyButton() {
        return '<button class="btn btn-default btn edit-duty"><span class="glyphicon glyphicon-wrench"></span></button>';
    }


});