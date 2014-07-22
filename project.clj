(defproject enlive-ws "0.1.1-SNAPSHOT"
  :description "enlive additions to strip whitespace"
  :url "https://github.com/jessesherlock/enlive-ws"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.googlecode.htmlcompressor/htmlcompressor "1.4"]
                 [enlive "1.1.5"]
                 ; htmlcompressor (or maybe YUI?) requires org.mozilla.javascript.ErrorReporter
                 ; be in the classpath, and it always is if you have a clojurescript dependency
                 ; so I never noticed
                 ; Someone with more JVM knowledge might know a better way to handle this, it seems stupid
                 [org.mozilla/rhino "1.7R4"]])
