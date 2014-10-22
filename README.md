# enlive-ws

A small addition to enlive to strip whitespace from templates on load.

It hooks in using the get-resource and register-resource! multimethods in enlive.

## Usage

For enlive templates you can use the reader macro or the type constructor

```clojure
 (ns demo
  (:require [net.cgrand.enlive-html :as e]
            [enlive-ws.core :as ew]))

 (e/deftemplate template-with-whitespace "templates/test.html"
   [data]
   [:div.test] (e/content data))

 (e/deftemplate template-without-whitespace (ew/->MiniHtml "templates/test.html")
   [data]
   [:div.test] (e/content data))

 (e/deftemplate template-without-whitespace2 #enlive_ws.core.MiniHtml["templates/test.html"]
   [data]
   [:div.test] (e/content data))
```

For Kioo enlive-ws is a dependency and minification is done by default.

## License

Copyright © 2014 Jesse Sherlock

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
