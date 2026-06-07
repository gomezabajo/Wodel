divert(-1)
   mfpic.m4                     Initialization for mfpic.

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

define(`m4picprocessor',dpic)
define(`m4postprocessor',mfpic)

ifdef(`libgen_',,`include(libgen.m4)divert(-1)')dnl

define(`thinlines_',`linethick = 0.4
  command "\pen{0.4pt}"
  arrowwid = 0.04*scale; arrowht = 0.2/3*scale;')
define(`thicklines_',`linethick = 0.8
  command "\pen{0.9pt}"
  arrowwid = 0.05*scale; arrowht = 0.1*scale;')
define(`linethick_',`linethick = ifelse(`$1',,`0.8',`$1')
  command sprintf("\pen{%gpt}",ifelse(`$1',,`0.9',linethick))
  arrowwid = ifelse(`$1',,`0.05',linethick/16)*scale; dnl
  arrowht = ifelse(`$1',,`0.1',linethick/8)*scale;')
divert(0)dnl
