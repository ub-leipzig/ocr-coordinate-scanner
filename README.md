# OCR-COORDINATE-SCANNER

A Camel API that produces a JSON serialization like this:

```json
{
  "contentList" : [
    {
      "objectId" : "word_1_1",
      "chars" : "IV",
      "region" : "311,241,54,32"
    },
    {
      "objectId" : "word_1_2",
      "chars" : "Einleitung.",
      "region" : "767,243,176,35"
    },
    {
      "objectId" : "word_1_3",
      "chars" : "die",
      "region" : "312,331,52,31"
    },
    {
      "objectId" : "word_1_4",
      "chars" : "Ideen",
      "region" : "380,330,103,32"
    },
    {"..." : "..."}
   ]
 }
```
with a request like this:

`
http://localhost:9085/scanner?type=scan&image=https://iiif.ub.uni-leipzig.de/iiif/j2k/0000/0080/0000008086/00000008.jpx&lang=deu
`

It depends on Tesseract v.3.0.5.  The image URI should source a IIIF image server source.

### USE CASE
The use case of this API is to produce elastic search documents for images that contain content coordinates and characters.

See [collections-ui](https://github.com/ub-leipzig/collections-ui) for an interface implementation.