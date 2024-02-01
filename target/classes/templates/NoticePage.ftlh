<#import "commons.ftlh" as c>

<@c.page>
    <#if user??>
        <div class="notice form-box">
            <div class="header">Register</div>
            <div class="body">
                <form method="post" action="">
                    <div class="field">
                        <div class="name">
                            <label for="text">Text</label>
                        </div>
                        <div class="value">
                            <textarea id="text" name="text" value="${textForm.content!}"></textarea>
                            <@c.error "textForm.text"/>
                        </div>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Publish">
                    </div>
                </form>
            </div>
        </div>
    <#else>
        No user found.
    </#if>
</@c.page>