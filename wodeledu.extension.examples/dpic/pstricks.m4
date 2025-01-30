divert(-1)
   pstricks.m4                  Initialization for PSTricks.

* Circuit_macros Version 10.2, copyright (c) 2023 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

define(`m4picprocessor',dpic)
define(`m4postprocessor',pstricks)

ifdef(`libgen_',,`include(libgen.m4)divert(-1)')dnl

define(`thinlines_',`linethick = 0.4
  arrowwid = 0.04*scale; arrowht = 0.2/3*scale
  command "\psset{linewidth=0.4pt}%";')

define(`thicklines_',`linethick = 0.8
  arrowwid = 0.05*scale; arrowht = 0.1*scale
  command "\psset{linewidth=0.8pt}%";')

                               `linethick_(x)
                                Set line width to x pt and default
                                arrowhead parameters'
define(`linethick_',`linethick = ifelse(`$1',,`0.8',`$1'); dnl
  arrowwid = ifelse(`$1',,`0.05',linethick/16)*scale; dnl
  arrowht = ifelse(`$1',,`0.1',linethick/8)*scale;')

                               `Patch PSTricks to use all coordinate pairs
                                inside \pscustom
                                Older version for PSTricks prior to Aug 2010:'
define(`M4PatchPSTricks',
`command "\makeatletter\@ifundefined{ifPst@noCurrentPoint}%
{\@ifundefined{MPS@Patch}{\gdef\MPS@Patch{}%
 \typeout{ Dpic -p: patching psbezier in pstricks.tex (some versions) }%
 \def\psbezier@ii{\addto@pscode{%
  \ifshowpoints true \else false \fi\tx@OpenBezier%
  \ifshowpoints\tx@BezierShowPoints\fi}\end@OpenObj}}{}}%
{\@ifundefined{MPS@PatchMsg}{\gdef\MPS@PatchMsg{}%
 \typeout{ Dpic -p: Setting noCurrentPoint to use all coord pairs }}{}%
 \psset{noCurrentPoint}}\makeatother%"')
                               `For PSTricks since Aug 2010:'
define(`M4PatchPSTricks',`command "\psset{noCurrentPoint}%"')

divert(0)dnl
