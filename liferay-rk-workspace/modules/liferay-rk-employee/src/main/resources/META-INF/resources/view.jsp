<%@ include file="/init.jsp" %>

<portlet:renderURL var="createEditRender">
	<portlet:param name="mvcRenderCommandName" value="/create/edit"/>
</portlet:renderURL>

<a href="${createEditRender}">Create Employee</a>