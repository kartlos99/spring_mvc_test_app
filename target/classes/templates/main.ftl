<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#include "parts/security.ftl" >

<@c.page>
    <div>
        <@l.logout/>
        <#if isAdmin>
            <span><a href="/user">users</a></span>
        </#if>
        <span>hello ${name}</span>
    </div>

    <div>
        <form method="post" action="main">
            <input type="text" name="title" placeholder="title"/>
            <input type="text" name="body" placeholder="msg"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">ჩაწერა</button>
        </form>
    </div>

    <div>მომხმარებლები</div>

    <div>
        <form method="get" action="main">
            <input type="text" name="filter" placeholder="title" value="${filter}"/>
            <button type="submit">ძებნა</button>
        </form>
    </div>

    <#list msg as message>
        <div>
            <b>${message.id}</b>
            <span>${message.title}</span>
            <i>${message.body}</i>
            <strong>${message.authorName}</strong>
        </div>
    <#else>
        <p>no message found!!</p>
    </#list>

</@c.page>