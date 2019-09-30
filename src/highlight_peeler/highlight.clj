(ns highlight-peeler.highlight
  (:require [clojure.string :as str]))

(defn book-named? [book-name highlight]
  (str/includes? (:book-title highlight) book-name))
