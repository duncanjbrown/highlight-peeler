(ns highlight-peeler.core
  (:require [highlight-peeler.csv :refer [load-csv-highlights]]
            [highlight-peeler.highlight :refer [book-named?]]
            [highlight-peeler.org-format :refer [highlight->org]]))

(defn extract-and-print-highlights
  [filename book]
  (->> (load-csv-highlights filename)
       (filter (partial book-named? book))
       (reverse) ; take them latest-first
       (map highlight->org)
       (apply str)
       (println)))

(defn -main
  [& args]
  (let [[filename book] *command-line-args*]
    (extract-and-print-highlights filename book)))
