<?xml version="1.0" encoding="UTF-8"?>
<xsl:transform
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="1.0"
>

    <xsl:template match="/">
        <html>
            <head>
                <title>Customers</title>
            </head>
            <body>
                <h1>Customers</h1>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>


    <xsl:template match="customers">
        <table style="border: 1px solid black;">
            <thead>
                <tr><th>ID</th><th>Name</th></tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>

    <xsl:template match="customer">
        <tr><td><xsl:value-of select="@id"/></td><td><xsl:apply-templates select="name"/></td></tr>
    </xsl:template>

    <xsl:template match="name">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()"/>
        </xsl:copy>
    </xsl:template>
</xsl:transform>
