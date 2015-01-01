<%--
  Created by IntelliJ IDEA.
  User: btaylor5
  Date: 12/31/14
  Time: 12:31 AM

  This HTML will be injected into the admin page for the HM's

--%>
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
              Duty Description
            </th>
            <%--<th>--%>
              <%--Class--%>
            <%--</th>--%>
            <%--<th>--%>
              <%--Fine Amount--%>
            <%--</th>--%>
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
              Clean out the Fridge (including old food), wipe down the microwave Clean out the Fridge (including old food), wipe down the microwave  Clean out the Fridge (including old food), wipe down the microwave

            </td>
            <td>
              <button class="btn btn-default btn edit-duty"><span class="glyphicon glyphicon-wrench"></span></button>
            </td>
          </tr>
          <tr class=".target">
          </tr>
          </tbody>
        </table>
        <button class="btn btn-default btn center-block new-Duty"><span class="glyphicon glyphicon-plus"></span></button>
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

