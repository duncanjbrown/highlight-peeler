(ns user
  (:require [highlight-peeler.core :as hp]
            [clojure.string :as str]))

(def csv (hp/load-and-parse-csv-file "/Users/duncan/Downloads/safari-annotations-export.csv"))

(->> csv
     (filter (partial book-named?
                      "Agile Software Development: The Cooperative Game, Second Edition"))
     (map highlight->org)
     (apply print))

(def filename "/Users/duncan/Downloads/safari-annotations-export.csv")
(def book "Agile Software Development: The Cooperative Game, Second Edition")

(hp/extract-and-print filename book)
