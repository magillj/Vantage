/**
 *   Created by btaylor5 on 12/31/14.
 *
 *   ONLY LOAD THIS FILE ON THE HM ADMIN PAGE
 *
 **/

"use strict";
$(document).ready(function(){

    var isDutySheetPopulated = false;


    $(".view-duties").click(function(){
        if (!isDutySheetPopulated) {
            loadingbar();
            getDuties();
            isDutySheetPopulated = true;
        }
    });


    // makes table rows clickable
    // on row click, will get information for that row and bring up more details
    function makeRowsClickable() {
        $('.duty-table tr').click(function() {
            var duty = $(this).children();
            var dutyInfo = {};
            for (var i = 0; i <= duty.length; i++) {
                //An Array[] doesn't have text() method, so use eq() instead to get values at each index
                var value = duty.eq(i).text();
                if(value) {
                    dutyInfo[duty.eq(i).attr('class').split(' ')[0]] = value;
                }
            }
            displayDutyDetails(dutyInfo);
        });
    }

    function displayDutyDetails(details) {
        $("#showDuty").text(details['dutyName']);

        $("#dutyInfo").empty()
            .append($('<div>').append($('<h4>').text("Description")))
                .append($('<p>').text(details['dutyDesc'])).append($('<hr>'))
            .append($('<div>').append($('<h4>').text("Class")))
                .append($('<p>').text(details['targetedClass'])).append($('<hr>'))
            .append($('<div>').append($('<h4>').text("Fine Amount")))
                .append($('<p>').text(details['fineAmount'])).append($('<hr>'))
            .append($('<div>').append($('<h4>').text("Active?")))
                .append($('<p>').text(details['isActive'])).append($('<hr>'));
    }


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
                    for (var i = 0; i < data.length; i++) {
                        addToDutyTable(data[i].dutyName, data[i].dutyDesc, data[i].targetedClass, data[i].fineAmount, data[i].active);
                    }
                    makeRowsClickable();
                }
        });
    }

    function loadingbar() {
        console.log("throw that loading bar in...");
    }

    //Adds a Duty to the duty table
    function addToDutyTable(dutyName, dutyDesc, targetClass, fineAmount, active) {
        $(".duty-table").find('tbody')
            .append($('<tr>').addClass("table-row").attr('data-toggle', "modal").attr('data-target', "#ShowDutyModal")
                .append($('<td class="dutyName">').text(dutyName))
                .append($('<td class="dutyDesc hidden">').text(dutyDesc))
                .append($('<td class="targetedClass">').text(targetClass))
                .append($('<td class="fineAmount">').text("$" + fineAmount))
                .append($('<td class="isActive hidden">').text(active))
        );
    }

    function editDutyButton() {
        return '<button class="btn btn-default btn edit-duty"><span class="edit-duty glyphicon glyphicon-wrench"></span></button>';
    }


});