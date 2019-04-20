<#macro login path btntext>
    <form action="${path}" method="post">
        <div class="form-group">
            <label for="user1">Username</label>
            <input type="text" class="form-control" id="user1"
                   placeholder="Enter Username" name="username">
        </div>
        <div class="form-group">
            <label for="pass1">Password</label>
            <input type="password" class="form-control" id="pass1" placeholder="Password" name="password">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary" >${btntext}</button>

<#--        <div><label> User Name : <input type="text" name="username"/> </label></div>-->
<#--        <div><label> Password: <input type="password" name="password"/> </label></div>-->

<#--        <div><input type="submit" value="${btntext}"/></div>-->
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>