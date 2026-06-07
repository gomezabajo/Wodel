divert(-1)
   svg.m4                       Initialization for svg output.

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

define(`m4picprocessor',dpic)
define(`m4postprocessor',svg)
                                Default is to produce svg for web documents
ifdef(`m4textprocessor',,`define(`m4textprocessor',xml)')

ifdef(`libgen_',,`include(libgen.m4)divert(-1)')dnl

# The following definitions are still subject to change.
# The use of changecom may cause difficulty for non-GNU m4.
# ---------------------------------------------------------------------------#
#
# If either nosvgformat or Inkscape is defined then the svg formatting
# macros are turned off.  Text formatting can then be done in Inkscape.

dnl Put define(`Inkscape') in the source for Inkscape input
ifelse(ifdef(`Inkscape',T)`'ifdef(`nosvgformat',T),T,
`define(`svg_it',`$1')
define(`svg_tt',`$1')
define(`svg_sf',`$1')
define(`svg_norm',`$1')
define(`svg_bf',`$1')
define(`svg_small',`$1')
define(`svg_fsize',`$1')
define(`svg_sub',`$1')
define(`svg_sup',`$1')
define(`svg_font',`$1')
define(`svg_symbol',`$1')
define(`svg_micro',`$1')
define(`svg_ohm',`$1')
define(`svg_lt',`$1')
define(`svg_gt',`$1')
',
`define(`svg_tspan',`patsubst(<tspan `$1'
>`$2'</tspan>,",\\")')
divert(-1)
                           `svg_font(fontname,nominal ht:dptextratio,textoffset)
                         or svg_font(fontname,nominal ht:dptextratio,textoffset,
                            text)
                            Note: nominal ht = text height in drawing units,
                              e.g. 12bp__ for 12pt text
                            actual height = nominal ht * dptextratio '
define(`svg_font',`m4thtmp=textht; ifinstr(`$2',:,
   `stacksplit_(`m4svgf',`$2',:)
    ifelse(m4svgf,,,`ifelse(`$4',,,`m4trtmp=dptextratio;') dnl
      dptextratio = m4svgf;')popdef(`m4svgf')dnl
    ifelse(m4svgf,,,`ifelse(`$4',,,`m4thtmp=textht;') dnl
      textht=(m4svgf)*dptextratio; ')undefine(`m4svgf')',
   `ifelse(`$4',,,`m4trtmp=dptextratio;') dptextratio=svgfontratio(`$1'); dnl
    ifelse(`$2',,,m4thtmp=textht; textht=(`$2')*dptextratio; )')dnl
  ifelse(`$3',,,`textoffset=`$3'; ')
command "<g patsubst(ifelse(`$1',,,
index(`$1',font),0,`$1',
index(`$1',style),0,`$1',
style="font-family:`$1'")
,",\\")>"
  `$4'
  ifelse(`$4',,,`command "</g>"; textht=m4thtmp; dptextratio=m4trtmp;')')

`e.g. svg_font(Times) 
      svg_font(Times,12bp__:0.66) 
      svg_font(Times,11bp__,1bp__,"text" at A) 
      svg_font(font-family="Times")
      svg_font(font-family="Times" font-style="italic")
      svg_font(style="font-family:Times; font-style:italic")

Some fairly safe choices: Arial, Helvetica, Times, Courier, Verdana, Georgia,
  Palatino, Garamond, Bookman, Cursive, Trebuchet MS, Arial Black, Impact.
'
                          `svgfontratio(fontname)
                           reasonable dptextratio values for common fonts'
define(`svgfontratio',`ifinstr(
`$1',Times,0.66,
`$1',sans-serif,0.71,
`$1',Arial,0.71,
`$1',Helvetica,0.71,
`$1',Courier,0.57,
`$1',Cursive,0.7,
`$1',Verdana,0.72,
`$1',Georgia,0.70,
`$1',Palatino,0.66,
`$1',Garamond,0.62,
`$1',Bookman,0.66,
`$1',Comic Sans MS,0.75,
`$1',Trebuchet MS,0.71,
`$1',Arial Black,0.71,
`$1',Impact,0.79,
dptextratio)')

define(`svg_baselineskip',`(textht/svgfontratio)')

`see http://www.ascii.cl/htmlcodes.htm
 and http://webdesign.about.com/od/localization/l/blhtmlcodes-gr.htm'
`These macros are used in strings so the double quote is entered as \". '
define(`svg_symbol',`changecom(,)`$1'changecom(`#',)')
define(`svg_it',`<tspan font-style=\"italic\">`$1'</tspan>')
define(`svg_tt',`<tspan font-family=\"Courier\">`$1'</tspan>')
define(`svg_sf',`<tspan font-family=\"Helvetica\">`$1'</tspan>')
define(`svg_norm',`<tspan font-style=\"normal\">`$1'</tspan>')
define(`svg_bf',`<tspan font-style=\"bold\">`$1'</tspan>')

dnl T0 GET %% in a sprintf string, set the size explicitly,
dnl  eg sprintf("x`'svg_sub(%g,50%)",i)

define(`svg_small',`svg_fsize(`$1',ifelse(`$2',,66,`$2'))')
define(`svg_fsize',`<tspan font-size=\"ifelse(`$2',,100,`$2')%\">`$1'</tspan>')

dnl                         svg_ul(text) Underline text
define(`svg_ul',`<tspan text-decoration=\"overline\">`$1'</tspan>')
dnl                         svg_ol(text) Overline text
define(`svg_ol',`<tspan text-decoration=\"overline\">`$1'</tspan>')

dnl 						svg_sup
dnl This is black magic but seems necessary to work with Firefox
dnl Arg 2: size of subscript font in percent
dnl Arg 3: vertical shift, e.g. svg_sub(1,,0.5ex) 
dnl Arg 4 shifts the subscript horizontally e.g., svg_sup(1,,,-0.5ex)
define(`svg_sup',`<tspan font-size=\"ifelse(`$2',,70,`$2')%\"
 dy=\"-ifelse(`$3',,1.5ex,`$3')\" dx=\"ifelse(`$4',,,`$4')\">`$1'</tspan><tspan
 font-size=\"ifelse(`$2',,70,`$2')%\" dy=\"ifelse(`$3',,1.5ex,`$3')\"
 dx=\"-0.5ex\"> </tspan>')dnl note the space

dnl This is black magic but seems necessary to work with Firefox
dnl Arg 2: size of subscript font in percent
dnl Arg 3: vertical shift, e.g. svg_sub(1,,0.5ex) 
dnl Arg 4 shifts the subscript horizontally
define(`svg_sub',`<tspan font-size=\"ifelse(`$2',,70,`$2')%\"
 dy=\"ifelse(`$3',,0.66ex,`$3')\" dx=\"ifelse(`$4',,,`$4')\">`$1'</tspan><tspan
 font-size=\"ifelse(`$2',,70,`$2')%\" dy=\"-ifelse(`$3',,0.66ex,`$3')\"
 dx=\"-0.5ex\"> </tspan>')dnl note the space



                            `svg_frac(numerator[:wid],denominator[:wid])
                             Basic fraction for simple arguments
                             wid is in drawing units'
define(`svg_frac',`define(`m4ex',`(textht*0.675)')dnl sans-serif: 0.8525
define(`m4num',`patsubst(`$1',:.*)')dnl
define(`m4den',`patsubst(`$2',:.*)')dnl
define(`m4numx',`ifinstr(`$1',:,((patsubst(`$1',.*:))/m4ex),len(`$1'))')dnl
define(`m4denx',`ifinstr(`$2',:,((patsubst(`$2',.*:))/m4ex),len(`$2'))')dnl
define(`m4mx',`max(m4numx,m4denx)')dnl
  "<tspan dx="+sprintf("\"%gex\"", m4mx/2)+"> </tspan><tspan dy=\"-1.2ex\"
    dx="+sprintf("\"%gex\"", (m4mx-m4numx)/2)+">m4num</tspan><tspan
    dy=\" 2.6ex\"
    dx="+sprintf("\"%gex\"", -m4numx/2-m4denx/2)+">m4den</tspan><tspan
    dy=\"-1.4ex\" dx="+sprintf("\"%gex\"", m4mx/2-m4denx/2)+"> </tspan>"
    line right m4mx*m4ex from Here+((m4mx/2-0.8)*m4ex,-0.2*m4ex)
    move to Here+(0,0.2*m4ex)
   {box invis wid last line.len ht 2.8*textht with .w at last line.start}
')

define(`svg_hat',`<tspan>svg_circ</tspan><tspan dx=\"-0.9ex\">`$1'</tspan>')

define(`svg_Delta',`svg_symbol(&`#'916;)')
define(`svg_Gamma',`svg_symbol(&`#'915;)')
define(`svg_Lambda',`svg_symbol(&`#'923;)')
define(`svg_Omega',`svg_symbol(&`#'937;)')
define(`svg_Phi',`svg_symbol(&`#'934;)')
define(`svg_Pi',`svg_symbol(&`#'928;)')
define(`svg_Psi',`svg_symbol(&`#'936;)')
define(`svg_Sigma',`svg_symbol(&`#'931;)')
define(`svg_Theta',`svg_symbol(&`#'920;)')
define(`svg_Xi',`svg_symbol(&`#'926;)')
define(`svg_alpha',`svg_symbol(&`#'945;)')
define(`svg_amp',`svg_symbol(&`#'38;)')
define(`svg_backsl',`svg_symbol(&`#'92;)')
define(`svg_beta',`svg_symbol(&`#'946;)')
define(`svg_chi',`svg_symbol(&`#'967;)')
define(`svg_circ',`svg_symbol(&`#'710;)')
define(`svg_comma',`svg_symbol(&`#'44;)')
define(`svg_deg',`svg_symbol(&`#'176;)')
define(`svg_delta',`svg_symbol(&`#'948;)')
define(`svg_emsp',`svg_symbol(&`#'8195;)')
define(`svg_ensp',`svg_symbol(&`#'8194;)')
define(`svg_epsilon',`svg_symbol(&`#'949;)')
define(`svg_equiv',`svg_symbol(&`#'8801;)')
define(`svg_eta',`svg_symbol(&`#'951;)')
define(`svg_gamma',`svg_symbol(&`#'947;)')
define(`svg_geq',`svg_symbol(&`#'8805;)')
define(`svg_grave',`svg_symbol(&`#'96;)')
define(`svg_gt',`svg_symbol(&`#'62;)')
define(`svg_iota',`svg_symbol(&`#'953;)')
define(`svg_kappa',`svg_symbol(&`#'954;)')
define(`svg_lambda',`svg_symbol(&`#'955;)')
define(`svg_leq',`svg_symbol(&`#'8804;)')
define(`svg_lparen',`svg_symbol(&`#'40;)')
define(`svg_lt',`svg_symbol(&`#'60;)')
define(`svg_micro',`svg_symbol(&`#'956;`$1')')
define(`svg_mu',`svg_symbol(&`#'956;)')
define(`svg_nu',`svg_symbol(&`#'957;)')
define(`svg_ohm',`svg_symbol(&`#'937;)')
define(`svg_omega',`svg_symbol(&`#'969;)')
define(`svg_phi',`svg_symbol(&`#'966;)')
define(`svg_pi',`svg_symbol(&`#'960;)')
define(`svg_pound',`svg_symbol(&`#'35;)')
define(`svg_prime',`svg_symbol(&`#'8242;)')
define(`svg_psi',`svg_symbol(&`#'968;)')
define(`svg_rho',`svg_symbol(&`#'961;)')
define(`svg_rparen',`svg_symbol(&`#'41;)')
define(`svg_sigma',`svg_symbol(&`#'963;)')
define(`svg_tau',`svg_symbol(&`#'964;)')
define(`svg_theta',`svg_symbol(&`#'952;)')
define(`svg_thinsp',`svg_symbol(&`#'8201;)')
define(`svg_tilde',`svg_symbol(&`#'126;)')
define(`svg_upsilon',`svg_symbol(&`#'965;)')
define(`svg_uscore',`svg_symbol(&`#'95;)')
define(`svg_xi',`svg_symbol(&`#'958;)')
define(`svg_zeta',`svg_symbol(&`#'950;)')
')

define(`svgcolor',`sprintf("rgb(%g,%g,%g)",\
int(`$1'+0.5),int(`$2'+0.5),int(`$3'+0.5))')

# Obsolete but kept for compatibility.  Use `rgbstring(r,g,b)'
define(`svgcolor255',
 `svgcolor(int((`$1')*255+0.5),int((`$2')*255+0.5),int((`$3')*255+0.5))')

define(`svgLink',`command "<a xlink:href=\"`$1'\"dnl
  ifelse(`$3',,`target=\"_blank\"',`$3',B,,`$3')>
  <g stroke=\"rgb(0,0,255)\">"
  `$2'
  command "</g></a>"')
define(`svgLinkString',`"<a xlink:href=\"`$1'\"dnl
  ifelse(`$3',,`target=\"_blank\"',`$3',B,,`$3') dnl
  stroke=\"rgb(0,0,255)\">dnl
 `$2' dnl
  </a>"')

#                          `svg_rot_init(filename)
#                           rotation is about the bottom centre
#                           filename is the basename of the output
#                           produced by dpic -v filename.pic > filename.svg'
define(`svg_rot_init',`
`# svg_rot'_init begin
 NeedDpicTools
 define(`_file_',ifelse(`$1',,patsubst(__file__,.m4),`$1'))
 syscmd( touch _file_.svg _file_.cor ; \
    sed -e "s/^.*x=/x=/" _file_.svg > _file_.tmp )
#                           Extract from the .svg file the x= y= coordinates
#                           that appear after each transform="rotate(.." line
 retcode = ( sh "awk \"/transform=\\"rotate/ { r=1 }; dnl
      /x=\\".*y=\\"/ { if(r==1){ print; r=0 } }\" _file_.tmp dnl
  | sed -e \"s/x=\\"\([0-9.]*\)\\" y=\\"\([0-9.]*\)\\".*/\1 \2/\" dnl
  > _file_.cor" )
 if retcode != 0 then { print "
   Awk failure.
   Awk and sed are required by svg_rot to rotate svg text.
   " } 
 svgrot_k = 0
 define svg_rotcoords { if "$`'1" != "" then { svgrot_k += 1
   svg_rx[svgrot_k] = $`'1; svg_ry[svgrot_k] = $`'2 }
   }
 copythru(svg_rotcoords, _file_.cor)
 sh "rm -f _file_.tmp _file_.cor"
 svgrot_i = 0

 ifdef(`svg_rot_',,`
#                          `svg_rot(degrees,"text" or object,[at position]) 
#                           Rotate text or object degrees ccw about its centre
#                           Requires svg_rot_init(filename)
#                           which uses both awk and sed.
#                           The source must be processed twice by m4 and dpic.'
 define svg_rot { if retcode != 0 then {$`'2} else {
  if "$`'1" != "" then { svg_rang = -($`'1) } else { svg_rang = -90 }
  if svgrot_k != 0 then { svgrot_i +=1
    command sprintf("<g transform=\"rotate(%g %g %g)\">",svg_rang,\
      svg_rx[svgrot_i], svg_ry[svgrot_i]) }\
  else { command sprintf("<g transform=\"rotate(%g)\">",svg_rang) }
  if "$`'3"=="" then { $`'2 } \
  else { $`'2 $`'3 - (sind(svg_rang),(cosd(svg_rang)-1))*textht/2 }
 command "</g>" } }
 define(`svg_rot_') ')
`# svg_rot'_init end
 ')

# ---------------------------------------------------------------------------#

define(`thinlines_',`linethick = 0.4
  arrowwid = 0.04*scale; arrowht = 0.2/3*scale')
define(`thicklines_',`linethick = 0.8
  arrowwid = 0.05*scale; arrowht = 0.1*scale')
                                `linethick_(x) set line width to x pt'
define(`linethick_',`linethick = ifelse(`$1',,`0.8',`$1'); dnl
  arrowwid = ifelse(`$1',,`0.05',linethick/16)*scale; dnl
  arrowht = ifelse(`$1',,`0.1',linethick/8)*scale;')

divert(0)dnl
