<#import "parts/common.ftl" as c>

<@c.page>
    <h3>user Editing ${usr.username}</h3>

    <form action="/user" method="post">
        <input type="hidden" name="userId" value="${usr.id}">
        userame : <input type="text" name="username" value="${usr.username}"/>
        <#list roles as role>
            <div>
                <label><input type="checkbox"
                              name="${role}" ${usr.roles?seq_contains(role)?string("checked", "")}/>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input type="submit" value="Save"/>
    </form>
</@c.page>