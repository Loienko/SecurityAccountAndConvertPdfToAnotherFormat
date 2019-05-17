<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

<jsp:include page="_menu.jsp"></jsp:include>

<h2>Work with Files</h2>

<br method="post" action="${pageContext.request.contextPath}/uploadFile" enctype="multipart/form-data">

Select file to upload:
<br>
<input type="file" name="file"/>
</br>

<br style="color: blue">Select the type to convert: </br>

<p> <input type="radio" name="html -> pdf" value="htmlToPdf">        html -> pdf
    <input type="radio" name="html -> pdf" value="PdfToHtml">        pdf -> html     </p>

<p> <input type="radio" name="image -> pdf" value="imageToPdf">      image -> pdf
    <input type="radio" name="image -> pdf" value="PdfToImage">      pdf -> image    </p>

<p> <input type="radio" name="txt -> pdf"  value="txtToPdf">         txt -> pdf
    <input type="radio" name="txt -> pdf" value="PdfToTxt">          pdf -> txt      </p>

<p> <input type="radio" name="word -> pdf" value="wordToPdf">        word -> pdf
    <input type="radio" name="word -> pdf" value="PdfToWord">        pdf -> word     </p>

<%--<br>
<input type="text" name="description" size="50"/>
<br/>--%>

<br>
<input type="submit" value="Upload"/>
</br>
</form>

</body>
</html>