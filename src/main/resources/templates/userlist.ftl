<#import "parts/common.ftl" as c>

<@c.page>
    <h3>users_list</h3>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th>Active</th>
            <th>link</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td>${user.active?c}</td>
                <td><a href="/user/${user.id}">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>