<div class="container">
    <div class="projects">
        <div class="container-input">
            <div class="customer-input" align="center" valign="middle" style=" margin-left: 50px;">
                Fill the table projects
                <form action="/project/project-create" method="post">
                    <input type="text" name="id" , placeholder="ID project">
                    <input type="text" name="project_name" , placeholder="Project name">
                    <input type="text" name="budget" , placeholder="Budget">
                    <input type="text" name="commandId" , placeholder="Command ID">
                    <button type="submit">Save</button>
                </form>
            </div>
        </div>
        <div class="table-projects" align="center" valign="middle" style=" margin-left: 50px;">
            <#if projects?has_content>
            <div class="table-customer">
                <table border="1" cellspacing="0" cellpadding="1">
                    <tr class="tableHeader">
                        <td>Project ID</td>
                        <td>Project Name</td>
                        <td>Budget</td>
                        <td>Command ID</td>
                    </tr>
                    <#list projects as project>
                        <tr class="tableBody">
                            <div>
                                <nobr>
                                    <td>${project.id}</td>
                                    <td>${project.project_name}</td>
                                    <td>${project.budget}</td>
                                    <td>${project.command_id}</td>
                                </nobr>
                            </div>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>

        <div class="container-delete">
            <div class="project-input" align="center" valign="middle" style=" margin-left: 50px;">
                select project id to delete
                <form action="/project/project-delete" method="post">
                    <input type="text" name="id" , placeholder="Project ID">
                    <button type="submit">Delete</button>
                </form>
            </div>
        </div>

        <#else>
            There are no projects yet.
        </#if>
        </table>
    </div>
</div>

<div class="commands">
    <div class="container-input">
        <div class="commands-input" align="center" valign="middle" style=" margin-left: 50px;">
            Fill the table commands
            <form action="/command/command-create" method="post">
                <input type="text" name="id" , placeholder="Id" required="required">
                <label for="persons">Enter the person name separated by commas:</label>
                <input type="text" name="persons" id="persons" required="required">
                <button type="submit">Save</button>
            </form>
        </div>
    </div>
    <div class="table-credit_cards" align="center" valign="middle" style=" margin-left: 50px;">
        <#if commands?has_content>
        <div class="table-credit_cards">
            <table border="1" cellspacing="0" cellpadding="1">
                <tr class="tableHeader">
                    <td>Command ID</td>
                    <td>Persons</td>
                </tr>
                <#list commands as command>
                    <tr class="tableBody">
                        <div>
                            <nobr>
                                <td>${command.id}</td>
                                <td>
                                    {
                                    <#list command.persons as cm>
                                        ${cm},
                                    </#list>
                                    }
                                </td>
                            </nobr>
                        </div>
                    </tr>
                </#list>
        </div>
        </table>
    </div>

    <div class="container-delete">
        <div class="command-input" align="center" valign="middle" style=" margin-left: 50px;">
            select command id to delete
            <form action="/command/command-delete" method="post">
                <input type="text" name="id" , placeholder="Command Id">
                <button type="submit">Delete</button>
            </form>
        </div>
    </div>

    <#else>
        There are no commands yet.
    </#if>
    </table>
</div>
</div>
</div>