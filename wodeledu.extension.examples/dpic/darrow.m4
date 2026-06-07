divert(-1)
  darrow.m4                     Macros for double lines and arrows

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

` Some of these macros have uncomfortably many arguments for specifying
  options, so wrappers beginning with upper-case letters (Dline,
  Darrow, Darc) are provided and implement key=val;key=val... option
  specifications.  Sometimes however, cleaner code results from using
  the original macros.  Could these be written in a more straightforward
  fashion? Probably, but the current versions have evolved from macros
  written very early on and backward compatibility has been kept, with
  only a few exceptions.

  The drawn elements are
    darc darrow dend dleft dline dright dtee dturn
  and there are wrappers
    Darc Darrow Dline
'
define(`darrow_')
ifdef(`libgen_',,`include(libgen.m4)divert(-1)')

=============================================================================
# Style defaults:
                                Default width (thickness) of double lines
define(`dlthick',`(0.08*scale+lthick)')

                               `ELement fill color (default white)
                                e.g. define(`dfillcolor',`1,0.84,0')'
define(`dfillcolor',`1,1,1')   `=white'

define(`dfillgrey',1)          `fill shade for gpic'
define(`darcrad',`dlthick*2')  `default darc radius'
define(`dfillext',0.25bp__) `extended length of dtee, dleft, dright fill'

                               `Default length:'
ifdef(`elen_',,`define(`elen_',linewid*3/2)')
=============================================================================

                               `deleminit_(linespec,len,dlinethick)
                                dline initialization'
define(`deleminit_',`define(`m4dlthk',ifelse(`$3',,dlthick,`$3'))dnl
  rpoint_(ifelse(`$1',,`to rvec_(ifelse(`$2',,linewid,`$2'),0)',`$1')) ')


                               `above, below, ljust, rjust but displaced
                                by dlthick/2 eg "string" dabove(at position)'
define(`dabove',`above ifelse(`$1',,`at Here',`$1')+(0,dlthick/2)')
define(`dbelow',`below ifelse(`$1',,`at Here',`$1')-(0,dlthick/2)')
define(`dljust',`ljust ifelse(`$1',,`at Here',`$1')+(dlthick/2,0)')
define(`drjust',`rjust ifelse(`$1',,`at Here',`$1')-(dlthick/2,0)')

               `dline(linespec,start truncation,end truncation,dlthick, ends,
                  outline attributes, inner attributes )
                  ends= blank, x-x, -x, x-, where x means ! or |'
define(`dline',`deleminit_(`$1',,`$4')
  M4DL: line invis from last line.start to last line.end \
    chop ifelse(`$2',,0,m4dlthk/2) chop ifelse(`$3',,0,m4dlthk/2)
  {line thick m4dlthk/(1bp__) `$6' from M4DL.start to M4DL.end }
  ifelse(rgbstring(dfillcolor),"",,
   `{line thick m4dlthk/(1bp__)-2*linethick \
      ifelse(`$7',,`outlined rgbstring(dfillcolor)',`$7') \
      from M4DL.start \
        ifinstr(`$5',|-,`+vec_(lthick,0)',`$5',!-,`+vec_(lthick/2,0)') \
      to M4DL.end \
        ifinstr(`$5',-|,`-vec_(lthick,0)',`$5',-!,`-vec_(lthick/2,0)') }')
  ifgpic(`M4dV: vec_(0,m4dlthk/2-lthick/2); shade(dfillgrey,
    {line from M4DL.start+(M4dV.x,M4dV.y) to M4DL.end+(M4dV.x,M4dV.y)}
    {line from M4DL.start-(M4dV.x,M4dV.y) to M4DL.end-(M4dV.x,M4dV.y)})')
   line invis from M4DL.start to M4DL.end')

                               `dleft(at position,dlthick,attribs)
                                Turn left, leaving current location
                                at exit of corner.
                                attribs=
                                  innershade=(r,g,b)|"color";
                                  outline=(r,g,b)|"color";'
define(`dleft',`deleminit_(,ifelse(`$2',,dlthick,`$2'),`$2')
  pushkeys_(`$3',innershade::N;outline::N;) dnl
  ifelse(`$1',,,`move to substr(`$1',eval(index(`$1',t)+1))-vec_(m4dlthk/2,0)')
  { line thick m4dlthk/(1bp__) to rvec_(m4dlthk,0) }
  ifelse(rgbstring(dfillcolor),"",,
   `{line thick m4dlthk/(1bp__)-2*linethick \
      m4fixcolor(outlined,m4innershade,`dfillcolor') \
      to rvec_(m4dlthk/2,0) then to rvec_(m4dlthk/2,m4dlthk/2+dfillext)}
    move to rvec_(m4dlthk/2,0) then to rvec_(m4dlthk/2,m4dlthk/2) ')
  ifgpic(`{line from rvec_(0,m4dlthk/2-lthick/2) to rvec_(0,m4dlthk/2-lthick/2)}
   {line from rvec_(m4dlthk-lthick/2,m4dlthk/2) \
     to rvec_(m4dlthk-lthick/2,-m4dlthk/2+lthick/2) then \
     to rvec_(0,-m4dlthk/2+lthick/2)}
   move to rvec_(m4dlthk/2,m4dlthk/2)') popdef(`m4innershade',`m4outline')
   rp_ang = rp_ang+pi__/2')
                               `dright(at position,dlthick,attribs)
                                Turn right, leaving current location
                                at exit of corner.
                                attribs=
                                  innershade=(r,g,b)|"color";
                                  outline=(r,g,b)|"color";'
define(`dright',`deleminit_(,ifelse(`$2',,dlthick,`$2'),`$2')
  pushkeys_(`$3',innershade::N;outline::N;) dnl
  ifelse(`$1',,,`move to substr(`$1',eval(index(`$1',t)+1))-vec_(m4dlthk/2,0)')
  { line thick m4dlthk/(1bp__) to rvec_(m4dlthk,0) }
  ifelse(rgbstring(dfillcolor),"",,
   `{line thick m4dlthk/(1bp__)-2*linethick \
      m4fixcolor(outlined,m4innershade,`dfillcolor') \
      to rvec_(m4dlthk/2,0) then to rvec_(m4dlthk/2,-m4dlthk/2-dfillext)}
    move to rvec_(m4dlthk/2,0) then to rvec_(m4dlthk/2,-m4dlthk/2) ')
  ifgpic(`{line from rvec_(0,-m4dlthk/2+lthick/2) \
                  to rvec_(0,-m4dlthk/2+lthick/2)}
   {line from rvec_(m4dlthk-lthick/2,-m4dlthk/2) \
     to rvec_(m4dlthk-lthick/2,m4dlthk/2-lthick/2) then \
     to rvec_(0,m4dlthk/2-lthick/2)}
   move to rvec_(m4dlthk/2,-m4dlthk/2)') popdef(`m4innershade',`m4outline')
   rp_ang = rp_ang-pi__/2')

                   `m4fixcolor(outlined|shaded,"colorname"|(r,g,b),colormacro)
                      define(`colormacro',`r,g,b')'
  define(`m4fixcolor',`ifelse(`$2',,`ifelse(`$3',,,``$1' rgbstring($3)')',
    index(`$2',`"'),0,``$1' `$2'' ,
    ``$1' rgbstring(m4ctrunc(`$2'))')')

                               `dturn(arg,dlthick,attribs) 
                                Turn arg relative degrees ccw
                                attribs=
                                  innershade=(r,g,b)|"color";
                                  outline=(r,g,b)|"color";'
define(`dturn',`deleminit_(,ifelse(`$2',,dlthick,`$2'),`$2')
[S: Here pushkeys_(`$3',innershade::N;outline::N;)
  deg = ifelse(`$1',,0,`$1')
  c = cosd(deg); s = sind(deg); sgn = sign(deg); r = (dlthick-lthick)/2
  G: S+vec_(lthick/2*abs(s),sgn*dlthick/2)
  A: S+vec_(lthick/2*abs(s),sgn*r)
  B: A+vec_(vscal_(lthick/2*abs(s),c,s))
  H: G+vec_(vscal_(lthick/2*abs(s),c,s))
  C: S+vec_(0, sgn*r)
  J: S+vec_(0, sgn*dlthick/2)
  if deg==0 then {t = 0} else { t = (1-c)/s } # t = tan(deg/2)
  D: A+vec_(vscal_(r*2,sgn*t,-sgn))
  E: B+vec_(vscal_(r*2,sgn*s,-sgn*c))
  F: S+vec_(0,-sgn*r)
  X: 0.5 between B and E
  ifelse(rgbstring(dfillcolor),`""',,`line thick 0 \
    m4fixcolor(outlined,m4innershade,`dfillcolor') \
    m4fixcolor(shaded,m4innershade,`dfillcolor') \
    from S to F then to D then to E then to H then to G then to J then to S')
  ifgpic(`m4tmpth = linethick; linethick=0
    shade(dfillgrey,`line from C to A then to B; line from E to D then to F')
    linethick = m4tmpth')
  line thick lthick/(1bp__) m4fixcolor(outlined,m4outline) from C to A then to B
  line thick lthick/(1bp__) m4fixcolor(outlined,m4outline) from E to D then to F
# Loopover_(`Px',`"Px" at Px above;', A,B,C,D,E,F,S,X)
# Loopover_(`Px',`"Px" at Px above;', G,H,J)
  `$4' popdef(`m4innershade',`m4outline')] with .S at Here
  move to last [].X
  ifelse(`$1',,,`Point_(`$1'+rp_ang*rtod_)') ')

                `darrow(linespec, start truncation, end truncation, dlthick,
                   arrowhd wid, arrowhd ht, terminals,color attribs)
                 terminals is blank or x-, ->, x->, <-, <-x, <-> where x is
                   ! for closed end with half-width line or
                   | for closed end with full-width line'
                 `e.g.,
                   linethick=5; rgbdraw(1,0,0,darrow(down_ 2,,,0.5,0.75,0.75,|)'

define(`darrow',`deleminit_(`$1',,`$4')
  arrow invis from last line.start to last line.end
  ifelse(ifinstr(`$7',<->,,`$7',<-,T),T,
   `define(`m4dx',`ifinstr(`$7',|,|,`$7',!,!)'->)dnl
    M4DA: line invis from last line.end to last line.start \
      chop ifelse(`$3',,0,m4dlthk/2) chop ifelse(`$2',,0,m4dlthk/2)
      rp_ang = rp_ang+pi__',
   `define(`m4dx',`$7')dnl
    M4DA: line invis from last line.start to last line.end \
      chop ifelse(`$2',,0,m4dlthk/2) chop ifelse(`$3',,0,m4dlthk/2)')
  [ C: M4DA.c; S: M4DA.start; E: M4DA.end
    w = ifelse(`$5',,m4dlthk*3/2,`$5')
    h = ifelse(`$6',,m4dlthk,`$6')
    d = sqrt((w/2)^2+h^2)
    p = d/w*lthick
    V: vec_(0,m4dlthk/2-lthick/2)
    T: vec_(h-lthick/2,0)
    P: vec_(p,0)
    Vt: vec_(0,w/2/h * (h-lthick/2-p))
    W: vec_(lthick/2,0)
    X: ifinstr(`$7',<->,C,m4dx,!,S,m4dx,|,S+(W.x,W.y),S)
  ifgpic(`shade(dfillgrey,') line dnl
  ifelse(rgbstring(dfillcolor),"",,`shaded rgbstring(dfillcolor)') `$8' from dnl
    ifinstr(m4dx,|,`X to X+(V.x,V.y) then',`X+(V.x,V.y)') to \
    E-(T.x,T.y)+(V.x,V.y) then to E-(T.x,T.y)+(Vt.x,Vt.y) \
    then to E-(P.x,P.y) \
    then to E-(T.x,T.y)-(Vt.x,Vt.y) then to E-(T.x,T.y)-(V.x,V.y) \
    then to dnl
    ifinstr(m4dx,<-,
     `S+(T.x,T.y)-(V.x,V.y) then to S+(T.x,T.y)-(Vt.x,Vt.y) \
      then to S+(P.x,P.y) \
      then to S+(T.x,T.y)+(Vt.x,Vt.y) then to S+(T.x,T.y)+(V.x,V.y) \
      then to X+(V.x,V.y)',
    m4dx,|,
     `X-(V.x,V.y) then to X',
    m4dx,!,
     `S-(V.x,V.y); line thick linethick/2 from S+(W.x/2,W.y/2)-(V.x,V.y) \
        to S+(W.x/2,W.y/2)+(V.x,V.y)
      line from S+(V.x,V.y) to X+(V.x,V.y)',
     `X-(V.x,V.y)') ifgpic(`)')
  ] with .C at M4DA.c
  ifelse(ifinstr(`$7',<->,,`$7',<-,T),T,
   `rp_ang = rp_ang-pi__
    arrow invis from M4DA.end to M4DA.start',
   `arrow invis from M4DA.start to M4DA.end')
')

                          `dtee([L|R],dlthick|attribs)
                           Construct tee with tail to back (default), left,
                           or right of current direction, leaving current
                           location at tee centre; eg
                           dline(right_,,t); dtee(R);
                           { darrow(down_,t) }; darrow(right_,t)
                           attribs:
                             thick=expr; (line thickness in drawing units)
                             innershade=(r,g,b)|"color";
                             outline=(r,g,b)|"color";'
define(`dtee',`pushkeys_(`$2',thick:m4nil;innershade::N;outline::N;)dnl
  deleminit_(,ifelse(m4thick,(m4nil),dlthick,m4thick))
  move to last line.c
  ifelse(`$1',L,`rp_ang = rp_ang-pi_/2', `$1',R,`rp_ang = rp_ang+pi_/2')
  ifelse(m4innershade,,,`pushdef(`dfillcolor',`m4ctrunc(m4innershade)')') dnl
  {line thick m4dlthk/(1bp__) dnl
    ifelse(m4outline,,,index(m4outline,`"'),0,`outlined m4outline',
    `outlined rgbstring(m4ctrunc(m4outline))') dnl
    from rvec_(-m4dlthk/2,0) to rvec_(m4dlthk/2,0)}
  pushdef(`m4dll',(m4dlthk/2+dfillext))dnl
  pushdef(`m4df',`rgbstring(dfillcolor)')dnl
  ifelse(m4df,"",,
   `{line thick m4dlthk/(1bp__)-2*linethick outlined m4df to rvec_(-m4dll,0) }
    {line thick m4dlthk/(1bp__)-2*linethick outlined m4df \
       from rvec_(0,-m4dll) to rvec_(0,m4dll) } ')
  ifgpic(`m4tmpth = linethick; linethick=0; shade(dfillgrey,
    {line from rvec_(-m4dlthk/2, m4dlthk/2) to rvec_( m4dlthk/2, m4dlthk/2)}
    {line from rvec_( m4dlthk/2,-m4dlthk/2) to rvec_(-m4dlthk/2,-m4dlthk/2)})
    linethick = m4tmpth')
  ifelse(m4innershade,,,`popdef(`dfillcolor')')dnl
  popdef(`m4thick',`m4innershade',`m4outline',`m4dll',`m4df')')

                           `dend([at position],dlthick|attribs)
                           Close off line end
                           attribs:
                             thick=expr; (line thickness in drawing units)
                             outline=(r,g,b)|"color";'
define(`dend',`pushkeys_(`$2',thick:m4nil;outline::N;)dnl
  pushdef(`m4thk',`ifelse(m4thick,(m4nil),dlthick,m4thick)')dnl
  ifelse(`$1',,,`move to patsubst(`$1',`^ *at *')')
  {line ifelse(m4outline,,,`outlined m4outline') ifinstr(`$2',=,,`$2') dnl
    from rvec_(0,-m4thk/2) to rvec_(0,m4thk/2) }
  move to rvec_(last line.thick pt__/2,0)dnl
  popdef(`m4thick',`m4outline',`m4thk')')

                `darc(center pos, radius, start radians, end radians, dlthick,
                      arrow wid, arrow ht, symbols,
                      outline attributes, inner attributes )
                 draw CCW arc in a [ ] block
                 symbols= x-, -x, x-x, ->, x->, <-, <-x, <->
                 where x is | or ! ; arrowheads for dpic only '
pushdef(`darc',`pushdef(`m4r',`(ifelse(`$2',,darcrad,`($2)'))') dnl
  pushdef(`m4C',`ifelse(`$1',,rvec_(0,m4r),`$1')') dnl
  pushdef(`m4as',`(ifelse(`$3',,rp_ang-pi__/2,`$3'))') dnl
  pushdef(`m4ae',`(ifelse(`$4',,m4as+pi__/2,`$4'))') dnl
  arc invis from m4C+(rect_(m4r,m4as)) to m4C+(rect_(m4r,m4ae)) with .c at m4C
  C_darc: last arc.c; Start_darc: last arc.start; End_darc: Here
  r_darc = m4r; as_darc = m4as; ae_darc = m4ae popdef(`m4r',`m4C',`m4as',`m4ae')
  dlth_darc=ifelse(`$5',,dlthick,(`$5'))
  w_darc = ifelse(`$6',,dlth_darc*1.75,(`$6'))
  h_darc = ifelse(`$7',,dlth_darc,(`$7'))
  p_darc = sqrt((w_darc/2)^2+h_darc^2)/(w_darc/2)*lthick
  tas_darc = as_darc ifinstr(`$8',<-,`+ p_darc/r_darc')
  tae_darc = ae_darc ifinstr(`$8',->,`- p_darc/r_darc')
  TS_darc: C_darc+(rect_(r_darc,tas_darc))
  TE_darc: C_darc+(rect_(r_darc,tae_darc))
  { arc thick dlth_darc/(1bp__) wid w_darc ht h_darc dnl
    ifinstr(`$8',<-,<-`'ifinstr(`$8',->,>),`$8',->,->) dnl
    `$9' from Start_darc to End_darc with .c at C_darc }
  pushdef(`m4inn',`ifelse(`$10',,`ifelse(rgbstring(dfillcolor),"",,
    ifdef(`dfillcolor',T),T,`outlined rgbstring(dfillcolor)')',`$10')') dnl
  ifelse(m4inn,,,
   `arc thick dlth_darc/(1bp__)-linethick*2 \
      wid (h_darc-p_darc-lthick)/h_darc*w_darc ht h_darc-p_darc-lthick \
      ifinstr(`$8',<-,<-`'ifinstr(`$8',->,>),`$8',->,->) \
      m4inn from TS_darc to TE_darc with .c at C_darc') popdef(`m4inn')
  ifinstr(`$8',|-,`X_darc: (vscal_(lthick/2,-sin(as_darc),cos(as_darc)))
    line `$9' \
    from C_darc+(rect_(r_darc+dlth_darc/2-lthick/2,as_darc))+X_darc to \
         C_darc+(rect_(r_darc-dlth_darc/2+lthick/2,as_darc))+X_darc',
  `$8',!-,`X_darc: (vscal_(lthick/4,-sin(as_darc),cos(as_darc)))
    line `$9' thick linethick/2 \
      from C_darc+(rect_(r_darc+dlth_darc/2-lthick/4,as_darc))+X_darc to \
           C_darc+(rect_(r_darc-dlth_darc/2+lthick/4,as_darc))+X_darc')
  ifinstr(`$8',-|,`X_darc: (vscal_(lthick/2,-sin(ae_darc),cos(ae_darc)))
    line `$9' from C_darc+(rect_(r_darc+dlth_darc/2-lthick/2,ae_darc))-X_darc \
      to C_darc+(rect_(r_darc-dlth_darc/2+lthick/2,ae_darc))-X_darc',
  `$8',-!,`X_darc: (vscal_(lthick/4,-sin(ae_darc),cos(ae_darc)))
    line `$9' thick linethick/2 \
      from C_darc+(rect_(r_darc+dlth_darc/2-lthick/4,ae_darc))-X_darc to \
           C_darc+(rect_(r_darc-dlth_darc/2+lthick/4,ae_darc))-X_darc')
  rp_ang := ae_darc+pi__/2 ')

                `Darc(center pos, radius, start radians, end radians, keys)
                   or
                 Darc(,keys)
                 draw CCW arc
                 keys is a semicolon-separated list:
                   thick=expr;  (total thickness, ie width)
                   wid=expr;    (arrowhead width)
                   ht=expr;     (arrowhead height)
                   outline=color; (e.g. "red" or (1,0,0) )
                   innershade=color;  (e.g. (0,1,1) or "cyan")
                   ends= x-, -x, x-x, ->, x->, <-, <-x, <-> where x is ! or |
                     < and > work for dpic only
                   |- closed end with full-width line
                   !- closed end with half-width line
                If arg1 is null then the additional list items are accepted:
                   centre=Position;
                   rad=expr;
                   startdeg=degrees;  NOTE: degrees
                   enddeg=degrees;    NOTE: degrees
                eg Darc(C,r,ang1,ang2,ends=<-|)'
define(`Darc',
 `pushkeys_(ifelse(`$1',,`$2',`$5'),thick:dlthick;wid:dlthick*1.75;ht:dlthick;
    outline::N;innershade::N;ends::N;centre:Here:N;rad:darcrad;
    startdeg::;enddeg::;)dnl
  pushdef(`m4ou',`m4fixcolor(outlined,m4outline)')dnl
  pushdef(`m4sh',`m4fixcolor(outlined,m4innershade,`dfillcolor')')dnl
  ifelse(`$1',,
   `darc(m4centre,m4rad,m4startdeg*dtor_,m4enddeg*dtor_,
      m4thick,m4wid,m4ht,m4ends,m4ou,m4sh)',
   `darc(`$1',`$2',ifelse(m4startdeg,,`$3',m4startdeg*dtor_),
     ifelse(m4enddeg,,`$4',m4enddeg*dtor_),
     m4thick,m4wid,m4ht,m4ends,m4ou,m4sh)') dnl
  popdef(`m4thick',`m4wid',`m4ht',`m4outline',`m4innershade',`m4ends',
    `m4centre',`m4rad',`m4startdeg',`m4enddeg',`m4ou',`m4sh')')')

               `darrow(linespec,keys)
                 keys is a semicolon-separated list of items:
                   s; truncate at start by dline thickness/2
                   e; truncate at end by dline thickness/2
                   thick=expr;   (total thickness, ie width)
                   wid=expr;     (arrowhead width)
                   ht=expr;      (arrowhead height)
                   outline=color; (e.g. "red" or (1,0,0) )
                   innershade=color;  (e.g. (0,1,1) or "cyan")
                   name=name;    (name of underlying invis line)
                   ends= -> or x-> or <- or <-x or <-> where x is | or ! 
                     |- closed end with full-width line
                     !- closed end with half-width line
                     eg Darrow(from A to B,E;ends=<-|)'
define(`Darrow',
 `pushkeys_(`$2',thick:dlthick;wid:dlthick*3/2;ht:dlthick;
    outline::N;innershade::N;name::N;ends::N;)dnl
  ifelse(m4innershade,,,`pushdef(`dfillcolor',`m4ctrunc(m4innershade)')')dnl
  pushdef(`m4nm',ifelse(m4name,,,m4name:))dnl
  ifelse(m4outline,,
   `m4nm darrow(`$1',ifinstr(`$2',S,t),ifinstr(`$2',E,t),
     m4thick,m4wid,m4ht,m4ends)',
  index(m4outline,`"'),0,
   `m4nm darrow(`$1',ifinstr(`$2',S,t),ifinstr(`$2',E,t),
     m4thick,m4wid,m4ht,m4ends,outlined m4outline)',
   `rgbdraw(m4ctrunc(m4outline),
     m4nm darrow(`$1',ifinstr(`$2',S,t),ifinstr(`$2',E,t),
     m4thick,m4wid,m4ht,m4ends))')
  ifelse(m4innershade,,,`popdef(`dfillcolor')')dnl
  popdef(`m4ends',`m4thick',`m4wid',`m4ht',`m4outline',`m4innershade',`m4name',
   `m4nm')')

               `Dline(linespec,keys)
                 keys is a semicolon-separated list of items:
                   S; truncate at start by dline thickness/2
                   E; truncate at end by dline thickness/2
                   thick=expr;   (total thickness, ie width)
                   outline=color; (e.g. "red" or (1,0,0) )
                   innershade=color;  (e.g. (0,1,1) or "cyan")
                   name=Name;
                   ends= x-x; or -x; or x-; where x is ! or |
                   |- closed end with full-width line
                   !- closed end with half-width line
                eg Dline(from A to B,E;ends=|-)'
define(`Dline',
 `pushkeys_(`$2',thick:dlthick;outline::N;innershade::N;ends::N;name::N;)dnl
  ifelse(m4name,,,m4name:) dline(`$1',ifinstr(`$2',S;,t),ifinstr(`$2',E;,t),
    m4thick,m4ends,m4fixcolor(outlined,m4outline),
                   m4fixcolor(outlined,m4innershade,`dfillcolor'))
  popdef(`m4thick',`m4outline',`m4innershade',`m4ends',`m4name') ')

define(`m4ctrunc',`substr(`$1',1,eval(len(`$1')-2))')

#efine(`mark',`{dot(at `$1'); "`$1'" at last [].s below}')
#efine(`pure',`patsubst(`$1',`"',`\\"')')
divert(0)dnl
