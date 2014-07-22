(ns enlive-ws.core
  (:require [net.cgrand.enlive-html :refer [get-resource
                                            register-resource!]]
            [net.cgrand.tagsoup :as tagsoup])
  (:import (com.googlecode.htmlcompressor.compressor HtmlCompressor)
           (java.io StringReader)))

; Other options here: https://code.google.com/p/htmlcompressor/#Using_HTML_Compressor_from_Java_API
; At this point the only non-default I care about is intertag spaces
; Should be quite easy to add others if they are ever needed or to make it configurable with a second
; param to the type

(defn html-compressor [] (doto (HtmlCompressor.) (.setRemoveIntertagSpaces true)))

(defn whitepace-stripping-tagsoup-parser [stream]
  (tagsoup/parser (StringReader. (.compress (html-compressor) (slurp stream)))))

(deftype MiniHtml [resource])

(defmethod get-resource MiniHtml
  [mh _]
  (let [loader whitepace-stripping-tagsoup-parser
        source (.resource mh)]
    (get-resource source loader)))

(defmethod register-resource! MiniHtml
  [mh]
  (register-resource! (.resource mh)))
