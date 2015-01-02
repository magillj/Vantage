<%--
  Created by IntelliJ IDEA.
  User: btaylor5
  Date: 12/31/14
  Time: 12:31 AM

  This HTML will be injected into the admin page for the HM's

--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="page-header">
    <h2>House Manager Utilities</h2>
</div>
<div class="accordion" id="accordion">
  <div class="accordion-group panel panel-danger">
    <a class="accordion-toggle whitesmoke" data-toggle="collapse" data-parent="#accordion" href="#collapse1">
      <div class="view-duties accordion-heading panel-body cardinal-red">
      Edit Duties
      </div>
    </a>
    <div id="collapse1" class="accordion-body collapse panel-footer">
      <div class="accordion-inner">
        <table class="table">
          <thead>
          <tr>
            <th>
              Duty Name
            </th>
            <th>
              Class
            </th>
            <th>
              Fine Amount
            </th>
            <th>
              Edit
            </th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>
              Fridge
            </td>
            <td>
              Freshmen
            </td>
            <td>
              $5
            </td>
            <td>
              <button class="btn btn-default btn edit-duty"><span class="glyphicon glyphicon-wrench"></span></button>
            </td>
          </tr>
          <tr class=".target">
          </tr>
          </tbody>
        </table>
        <button class="btn btn-default btn center-block new-Duty" data-toggle="modal" data-target="#NewDutyModal"><span class="glyphicon glyphicon-plus"></span></button>
        <%--MODAL FOR NEW DUTY--%>
        <!-- Modal -->
        <div class="modal fade" id="NewDutyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
              </div>
              <form class="form-horizontal" method="POST" action="<c:url value='/HM/NewDuty' />">
              <div class="modal-body">
                  <div class="form-group-sm">
                    <label for="dutyTitle" class="">Duty Title</label>
                    <input name="dutyTitle" id="dutyTitle" class="form-control" placeholder="Duty Title" required autofocus>
                  </div>
                  <div class="form-group-sm">
                    <label for="dutyDesc" class="">Duty Description</label>
                    <textarea name="dutyDesc" id="dutyDesc" class="form-control" placeholder="Duty Description..." required ></textarea>
                  </div>
                  <div class="form-group-sm">
                    <label for="dutyClass" class="">Class</label>
                    <select name="dutyClass" id="dutyClass" class="form-control">
                      <option value="Freshman">Freshman</option>
                      <option value="Sophomore">Sophomore</option>
                    </select>
                  </div>
                  <div class="form-group-sm">
                    <label for="dutyFine" class="">Fine Amount</label>
                    <select name="dutyFine" id="dutyFine" class="form-control" required>
                      <option value="5">5</option>
                      <option value="10">10</option>
                      <option value="15">15</option>
                      <option value="20">20</option>
                      <option value="25">25</option>
                    </select>
                  </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-large btn-default" data-dismiss="modal">Cancel</button>
                <button name="submit" type="submit" class="btn btn-large btn-primary">Add Duty</button>
              </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
  </div>

  <%--Accordion #2--%>
  <div class="accordion-group panel panel-primary">
    <div class="accordion-heading panel-body">
      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
        Title 1
      </a>
    </div>
    <div id="collapse2" class="accordion-body collapse panel-footer">
      <div class="accordion-inner">
        Text 1
      </div>
    </div>
  </div>

  <%--Accordion #3--%>
  <div class="accordion-group panel panel-primary">
    <div class="accordion-heading panel-body">
      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
        Title 1
      </a>
    </div>
    <div id="collapse3" class="accordion-body collapse panel-footer">
      <div class="accordion-inner">
        Text 1
      </div>
    </div>
  </div>
</div>

