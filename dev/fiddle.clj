(ns fiddle
  (:require [highlight-peeler.core :refer :all]
            [highlight-peeler.csv :as hp.csv]
            [highlight-peeler.highlight :as hp.highlight]
            [clojure.inspector :as inspector]
            [clojure.string :as str]))

(comment
  (def csv (hp.csv/load-csv-highlights "/Users/duncan/Downloads/safari-annotations-export.csv"))

  (def filename "/Users/duncan/Downloads/safari-annotations-export.csv")

  (def highlights (hp.csv/load-csv-highlights filename))
  (def book "Agile Software Development: The Cooperative Game, Second Edition")
  (def book "Agile Software Development")

  (extract-and-print-highlights filename book)

  (inspector/inspect (first highlights)))

(re-find #"abc" "abcdef")
; "abc"

(re-find #"abc" "def")
; nil

(if (re-find #"abc" "abc")
  true
  false)
                                        ; true
(str/includes? "football" "foot")
; true
