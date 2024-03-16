<%@ include file="/init.jsp" %>
<portlet:actionURL name="saveEmployee" var="saveEmployeeURL" />

<a href="${saveEmployeeURL}">Save</a>

<aui:form name="saveEmpFm" action="${saveEmployeeURL}">
<aui:input name="name"></aui:input>
<aui:input name="phoneNumber"></aui:input>
<aui:input name="salary"></aui:input>
<aui:input name="emailAddress"></aui:input>
<aui:input name="joiningDate"></aui:input>
<aui:input name="leavingDate"></aui:input>

<aui:button-row>
             <aui:button cssClass="btn btn-primary" type="submit" />
    </aui:button-row>

</aui:form>>