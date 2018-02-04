<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


           <%-- <form type="form" action="gendarme.html" >
                <div>
                    <p>nom</p>
                    <input type="text" name="fname"/>
                </div>
                <div>
                    <p>prenom</p>
                    <input type="text" name="lname"/>
                </div>
                <div>
                    <p>Address</p>
                    <input type="text" name="address"/>
                </div>
                <div>
                    <p>CIN</p>
                    <input type="text" name="cin"/>
                </div>
                <div>
                    <p>Mle/c</p>
                    <input type="text" name="mle"/>
                </div>
                <div>

                    <p>section</p>
                    <select name="idsection">
                        <c:forEach var="section" items="${section}">
                            <option value="${section.id}">${section.SectionName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <p>service</p>
                    <select name="idservice">
                        <c:forEach var="service" items="${service}">
                            <option value="${service.id}">${service.ServiceName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <p>grade</p>
                    <select name="idgrade">
                        <c:forEach var="grade" items="${grade}">
                            <option value="${grade.id}">${grade.grade}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <p>Badge id</p>
                    <select name="idbadge">
                        <c:forEach var="badge" items="${badge}">
                            <option value="${badge.id}">${badge.id}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>

                    <input type="submit" value="Valide">
                </div>
</form>--%>

<c:forEach items="${grade}" var="grade">
    ${grade.id}
    ${grade.grade}
</c:forEach>

------------------------------------

<c:forEach var="badge" items="${badge}">
    <option value="${badge.id}">${badge.id}</option>
</c:forEach>

<select name="idservice">
    <c:forEach var="service" items="${services}">
        <option value="${service.id}">${service.ServiceName}</option>
    </c:forEach>
</select>

<select name="idsection">
    <c:forEach var="section" items="${sections}">
        <option value="${service.id}">${service.SectionName}</option>
    </c:forEach>
</select>
<jsp:include page="../footer.jsp"/>
