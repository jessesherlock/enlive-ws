# enlive-ws

A small addition to enlive to strip whitespace from templates on load.

It hooks in using the get-resource and register-resource! multimethods in enlive.

Thanks to clojure's deftype creating a reader macro for you it also works in Kioo to avoid those stupid empty span tags caused by whitespace in templates interacting with React.

It's not an ideal solution but it's my second proof of concept and nice enough to use that I'm using it in code that will go to production as soon as it's done.

I expect a more permanent solution will arrive in Kioo at some point soon.

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

For Kioo templates you have to use the reader macro

```clojure
 (ns demo2
   (:require [kioo.om :as k])
   (:require-macros [kioo.om :refer [deftemplate]]
                    [enlive-ws.core])

   (deftemplate template-without-whitespace
     #enlive_ws.core.MiniHtml["templates/header.html"]
     [data]
     {[:span.date] (k/content data)})
```

## License

Copyright © 2014 Jesse Sherlock

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
