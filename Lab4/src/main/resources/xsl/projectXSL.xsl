<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <div class="links">
            <div align="center">
                <h1>Project</h1>
            </div>
        </div>
        <div class="customer-input" align="center" valign="middle" style=" margin-left: 50px;">
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>Project ID</strong>
                    </td>
                    <td>
                        <strong>Project Name</strong>
                    </td>
                    <td>
                        <strong>Budget</strong>
                    </td>
                    <td>
                        <strong>Command ID</strong>
                    </td>
                </tr>
                <xsl:for-each select="ArrayList/item">
                    <tr>
                        <td>
                            <xsl:value-of select="id"/>
                        </td>
                        <td>
                            <xsl:value-of select="project_name"/>
                        </td>
                        <td>
                            <xsl:value-of select="budget"/>
                        </td>
                        <td>
                            <xsl:value-of select="command_id"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>
        <div align="center">
            <p>
                <b>
                    <a href="/api/xsl/command">Command</a>
                </b>
            </p>
        </div>
    </xsl:template>
</xsl:stylesheet>