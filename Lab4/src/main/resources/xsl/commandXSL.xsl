<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <div class="topic">
            <div align="center">
                <h1>Commands</h1>
            </div>
        </div>
        <div class="customer-input" align="center" valign="middle" style=" margin-left: 50px;">
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>Command ID</strong>
                    </td>
                    <td>
                        <strong>Persons</strong>
                    </td>
                </tr>
                <xsl:for-each select="ArrayList/item">
                    <tr>
                        <td>
                            <xsl:value-of select="id"/>
                        </td>
                        <td>
                            <xsl:for-each select="persons/persons">
                                <xsl:value-of select="."/>
                                <xsl:text>, </xsl:text>
                            </xsl:for-each>
                        </td>


                    </tr>
                </xsl:for-each>
            </table>
        </div>
        <div align="center">
            <p>
                <b>
                    <a href="/api/xsl/project">Projects</a>
                </b>
            </p>
        </div>
    </xsl:template>
</xsl:stylesheet>