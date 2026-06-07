divert(-1)
   pgf.m4                  Initialization for Tikz-pgf.

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

define(`m4picprocessor',dpic)
define(`m4postprocessor',pgf)

ifdef(`libgen_',,`include(libgen.m4)divert(-1)')dnl

define(`ultrathinlines_',`linethick = 0.1
  arrowwid = 0.03*scale; arrowht = 0.04*scale ')
define(`verythinlines_',`linethick = 0.2
  arrowwid = 0.04*scale; arrowht = 0.05*scale ')
define(`thinlines_',`linethick = 0.4
  arrowwid = 0.04*scale; arrowht = 0.2/3*scale ')
define(`semithicklines_',`linethick = 0.6
  arrowwid = 0.045*scale; arrowht = 0.8*scale ')
define(`thicklines_',`linethick = 0.8
  arrowwid = 0.05*scale; arrowht = 0.1*scale ')
define(`verythicklines_',`linethick = 1.2
  arrowwid = 0.05*3/2*scale; arrowht = 0.1*3/2*scale ')
define(`ultrathicklines_',`linethick = 1.6
  arrowwid = 0.05*2*scale; arrowht = 0.1*2*scale ')
                                `linethick_(x) set line width to x pt'
define(`linethick_',`linethick = ifelse(`$1',,`0.8',`$1'); dnl
  arrowwid = ifelse(`$1',,`0.05',linethick/16)*scale; dnl
  arrowht = ifelse(`$1',,`0.1',linethick/8)*scale;')

dnl                         `tikznode(tikz_node_name,[location],[string])
dnl                          Define a tikz node at location (default Here)
dnl                          Must be used in the outermost scope of a pic
dnl                          diagram, and .PS <number> scaling is not allowed
dnl                          (thanks to Arnold Knott).'
define(`tikznode',`command dnl
  sprintf("\draw (%g,%g) node[inner sep=0pt, minimum size=0pt](`$1'){`$3'};",dnl
  ifelse(`$2',,Here,`($2)').x/scale,ifelse(`$2',,Here,`($2)').y/scale)')

divert(0)dnl
