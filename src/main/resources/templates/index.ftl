<#import "/spring.ftl" as spring/>

<html>

    <body>

        <h1><@spring.message "greeting"/></h1>

        <span><@spring.message "lang.change"/></span>

        <a href="?lang=pt">
            <@spring.message "lang.pt"/>
        </a>
        <a href="?lang=en">
            <@spring.message "lang.eng"/>
        </a>

    </body>
</html>