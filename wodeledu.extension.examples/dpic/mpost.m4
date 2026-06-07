divert(-1)
   mpost.m4                     Initialization for metapost.

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

define(`m4picprocessor',dpic)
define(`m4postprocessor',mpost)

ifdef(`libgen_',,`include(libgen.m4)divert(-1)')dnl

# Note: dpic uses Adobe points for line widths to conform to PSTricks
define(`thinlines_',`linethick = 0.4
   arrowwid = 0.04*scale; arrowht = 0.2/3*scale;')
define(`thicklines_',`linethick = 0.8
   arrowwid = 0.05*scale; arrowht = 0.1*scale;')
define(`linethick_',`linethick = ifelse(`$1',,`0.8',`$1')
   arrowwid = ifelse(`$1',,`0.05',linethick/16)*scale; dnl
   arrowht = ifelse(`$1',,`0.1',linethick/8)*scale;')

                                xcolor predefined colors
define(`defineRGBprimaries',`
define(`white',`(1,1,1)')dnl
define(`lightgrey',`(0.75,0.75,0.75)')dnl
define(`lightgray',`(0.75,0.75,0.75)')dnl
define(`grey',`(0.5,0.5,0.5)')dnl
define(`gray',`(0.5,0.5,0.5)')dnl
define(`darkgrey',`(0.25,0.25,0.25)')dnl
define(`darkgray',`(0.25,0.25,0.25)')dnl
define(`black',`(0,0,0)')dnl
define(`red',`(1,0,0)')dnl
define(`green',`(0,1,0)')dnl
define(`blue',`(0,0,1)')dnl
define(`cyan',`(0,1,1)')dnl
define(`magenta',`(1,0,1)')dnl
define(`yellow',`(1,1,0)')dnl
define(`brown',`(0.59,0.29,0)')dnl
define(`lime',`(0.8,1,0)')dnl
define(`olive',`(0.5,0.5,0)')dnl
define(`orange',`(1,0.5,0)')dnl
define(`pink',`(1,0.75,0.8)')dnl
define(`purple',`(0.5,0,0.5)')dnl
define(`teal',`(0,0.5,0.5)')dnl
define(`violet',`(0.56,0,1)')dnl
')

divert(0)dnl
