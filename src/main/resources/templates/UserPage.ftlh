<#import  "/spring.ftl" as spring>
<#import  "commons.ftlh" as c>

<@c.page>
    <div>
        <#if profile??>
            <p>id : ${profile.id}</p>
            <p>login : ${profile.login}</p>
            <p>creationTime : ${profile.creationTime}</p>
        <#else>
            <p>No such user</p>
        </#if>
    </div>
</@c.page>