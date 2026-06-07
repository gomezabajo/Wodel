divert(-1)
 
  libSLD.m4                    Draft macros for single-line diagram elements

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

==========================================================================

# These *DRAFT* definitions are for single-line diagram (SLD) elements
# with or without attached circuit breakers or slashes.  Many other elements
# applicable to SLD drawings are already in libcct.m4.  The contributions
# and suggestions of Benjamin Vilmann and Peter Jan Randewijk are
# acknowledged with thanks.

# The line
#   include(libSLD.m4)
# loads these definitions for use in a diagram.

# Notes for 1-terminal SLD elements:
# Argument 1 is normally the linespec of the stem to set the direction
#   and length.; e.g., D1: sl_disk draws a default disk with stem named D1.
# For a 0-length stem (which has undefined direction):
#   arg1 can also be U, D, L, R (for up, down, left, right),
#   or a number to set the direction in degrees, optionally followed by
#   `at position' to set the position (Here by default).
#   Zero-length stem examples: sl_box(U), sl_box(45 at Here+(1,0))
# Argument 2 contains semicolon (;)-separated key-value attributes
#   of the element head as applicable: e.g., name=Carol; text="Stop"; lgth=expr 
# If argument 3 is blank then a plain stem is drawn as described below.
# The element body (head) can be named with name= . The default name is Head.
# The head is overlaid with or contained in a [] block.

# Notes for 2-terminal SLD elements:
# These obey the normal Circuit_macro two-terminal conventions.
# They can be labelled using rlabel() or llabel() as well as directly.
# Argument 2 contains key-value pairs to customize the element body,
#   e.g., name=Name; text="text"; wdth=expr; ...
# Except for sl_drawout and sl_breaker which do not have series breakers
# or slashes, nonblank arguments 3 and 4 put a breaker slash symbol
# in the input and output respectively as described below.

# Notes for attached breakers and slashes:
# Nonblank arguments 3 and 4 of the two-terminal elements and argument 3 of
#   the 1-terminal elements specify a breaker in the input, output,
#   and stem respectivlely.  A non-blank argument is C for a default
#   closed breaker in the stem, O for an open breaker, or X, /, or \ to
#   put these symbols in the box; if the argument begins with S: or Sn:
#   (where n is an integer) then an n-line slash symbol is drawn rather
#   than a breaker; otherwise or in addition, key-value pairs specify
#   details of the object.  The separation of the breaker or slash
#   from the element body or head is given by parameter sl_breakersep_
#   or key sep=expr.  If this key is in the body or head keys then it
#   applies to both 2-terminal stem lines; it can also be given for each
#   stem individually.

# Notes for composite elements within a [ ] block:
#   The current transformer macro sl_ct has internal labels defined as
#   appropriate to the element.  The macro sl_transormer3 has 3 principal
#   termianls and other defined points.  Macro sl_busbar has internal
#   labels P1 to Pnp, Start, and End.

define(`sldlib_')
ifdef(`libcct_',,`include(libcct.m4)divert(-1)')

# Default size parameters.  These can be redefined in a diagram source.

define(`sl_breakersize_',`dimen_*3/16')  # breaker box size
define(`sl_breakersep_',`dimen_/2')      # breaker separation from body
define(`sl_ttboxlen_',`dimen_*3/4')      # inline box length
define(`sl_ttboxwid_',`dimen_*3/4')      # inline box width
define(`sl_sboxlen_',`dimen_*2/3')       # stem box length
define(`sl_sboxwid_',`dimen_*2/3')       # stem box wid
define(`sl_diskdia_',`dimen_*2/3')       # sl_disk diam
define(`sl_chevronsiz_',`dimen_/4')      # sl_drawout (chevron) size
define(`sl_loadwid_',`dimen_*0.32')      # load width
define(`sl_loadlen_',`dimen_*0.45')      # load length
define(`sl_transcale_',1)                # transformer body scale factor
define(`sl_busthick_',linethick*2)       # sl_bus line thickness
define(`sl_busindent_',`min(dimen_/5,rp_len/5)') # busbar end indent

# One-terminal elements ###################################################

                            `sl_disk( stem linespec, keys, breaker or Sn:slash)
                                 keys: name=Name;
                                       text="text";
                                       diam=expr;
                                       circle=other circle attributes; eg shade'
                                `default breaker name Br'
define(`sl_disk',
`sl_eleminit_(`$1')
 pushkeys_(`$2',`name:Head:N; circle::N; text::N; diam:sl_diskdia_')dnl
 ifelse(`$3',,
  `m4name: circle diam m4diam \
     at last line.end + vec_(m4diam/2,0) m4circle m4text
   [ box invis wid_ m4diam ht_ m4diam ] at last circle
   line from last line.end  to last line.start',
  `m4_one(`sl_disk',$@)') dnl
 popdef(`m4name', `m4circle', `m4text', `m4diam') ')

                            `sl_box( stem linespec, keys, breaker or Sn:slash)
                                 keys: name=Name; lgth=expr; wdth=expr;
                                       text="text";
                                       box= box attributes; (e.g. shade "red")'
                                `default breaker name Br'
define(`sl_box',
`sl_eleminit_(`$1')
 pushkeys_(`$2',`name:Head:N; wdth:sl_sboxwid_; lgth:sl_sboxlen_; box::N;
   text::N')dnl
 ifelse(`$3',,
  `line from last line.end to last line.start 
   { m4name: [S:Here; lbox(m4lgth,m4wdth,m4box)] \
       with .S at last line.start }
   ifelse(m4text,,,`{m4text at last []}')',
  `m4_one(`sl_box',$@)') dnl
 popdef(`m4name', `m4wdth', `m4lgth', `m4box', `m4text') ')

                            `sl_grid( stem linespec, keys, breaker or Sn:slash)
                                 keys: name=Name; lgth=expr; wdth=expr;'
                                `default breaker name Br'
define(`sl_grid',
`sl_eleminit_(`$1')
 pushkeys_(`$2',`name:Head:N; wdth:sl_sboxwid_; lgth:sl_sboxlen_; box::N')dnl
 ifelse(`$3',,
  `line from last line.end to last line.start 
   { m4name: [ S:Here
     { lbox(m4lgth,m4wdth) }
     { line to rvec_(m4lgth/2, m4wdth/2)
       line to rvec_(m4lgth/2,-m4wdth/2) }
     { line to rvec_(m4lgth/2,-m4wdth/2)
       line to rvec_(m4lgth/2, m4wdth/2) }
     { line from rvec_(0,m4wdth/2) to rvec_(m4lgth,-m4wdth/2) }
     line from rvec_(0,-m4wdth/2) to rvec_(m4lgth,m4wdth/2)
     ] with .S at last line.start } ',
  `m4_one(`sl_grid',$@)') dnl
 popdef(`m4name', `m4wdth', `m4lgth', `m4box') ')

                            `sl_load( stem linespec, keys, breaker or Sn:slash)
                                 keys: name=Name; lgth=expr; wdth=expr;
                                       head= arrowhead attributes;
                                 default breaker name is Br'
define(`sl_load',
`sl_eleminit_(`$1')
 pushkeys_(`$2',`name:Head:N; wdth:sl_loadwid_; lgth:sl_loadlen_; head::N')dnl
 ifelse(`$3',,
  `line from last line.end to last line.start 
   { m4name: [S:Here; line to rvec_(0,m4wdth/2) \
       then to rvec_(m4lgth,0) then to rvec_(0,-m4wdth/2) \
       then to Here m4head ] with .S at last line.start } ',
  `m4_one(`sl_load',$@)') dnl
 popdef(`m4name', `m4wdth', `m4lgth', `m4head') ')

                            `sl_meterbox( stem linespec, keys,
                                          breaker or Sn:slash )
                                  keys: sl_box attributes
                                 default breaker name is Br'
define(`sl_meterbox',
`sl_eleminit_(`$1')
 pushkeys_(`$2',`name:Head:N; wdth:sl_ttboxwid_; lgth:sl_ttboxlen_; box::N;
   text::N')dnl
 ifelse(`$3',,
  `line from last line.end to last line.start 
   {m4name: [S:Here;
     { B: rotbox( m4lgth, m4wdth, m4box ) with .W at S }
     a = rp_ang*rtod_
     if (abs(a-90) < 45) || (abs(a-180) < 45) || (abs(a+180) < 45) then { 
       C: rvec_(m4lgth*2/5,0)
       line from rvec_(m4lgth*4/5,m4wdth/2) to rvec_(m4lgth*4/5,-m4wdth/2) } \
     else { C: rvec_(m4lgth*3/5,0)
        line from rvec_(m4lgth/5,m4wdth/2) to rvec_(m4lgth/5,-m4wdth/2) }
     ifelse(m4text,,,`m4text at C')
     ] with .S at last line.start}',
  `m4_one(`sl_meterbox',$@)') dnl
 popdef(`m4name', `m4wdth', `m4lgth', `m4box', `m4text') ')

                            `sl_generator( stem linespec, keys,
                                 breaker or Sn:slash)
                                 keys:
                                   name= head name;
                                   type=AC|WT|BS|StatG|PV|Y|Delta;
                                   (type PV): sl_box keys name, lgth, wdth,
                                     text,box;
                                   (otherwise): sl_disk body keys name,
                                     text, diam, circle;
                                 default breaker name is Br
                                 Arg5 can be Y;name=Name with default
                                   name headname_Y,
                                   or Delta;name=Name with
                                   default name headname_D'
define(`sl_generator',
`pushkeys_(`$2',`type:AC:N; name:Head:N; lgth:sl_sboxlen_; wdth:m4lgth/2;
   box::N; text::N')dnl
 ifelse(m4type,PV,
  `sl_box(`$1',wdth=m4lgth*0.6;`$2',`$3')
   {line from m4name.S+vec_(0,m4wdth*0.45) \
    to m4name.S+vec_(m4wdth/2,0) \
    then to m4name.S+vec_(0,-m4wdth*0.45)}',
`sl_disk($@)
 m4lcd = last circle.diam
 { ifinstr(m4type,AC,
    `{ ACsymbol(at last circle,,,R) }',
   m4type,Y,
    `pushkey_(`$3',name,m4name`'_Y,N)dnl
     {m4name:Ysymbol(with .N at last circle,size=m4lcd/4) } popdef(`m4name')',
   m4type,Delta,
    `pushkey_(`$3',name,m4name`'_Y,N)dnl
     {m4name:Deltasymbol(with .N at last circle,size=m4lcd/4) }dnl
       popdef(`m4name')',
   m4type,WT,
    `{ Windturbine(with .N at last circle.c,size=m4lcd*0.9) }',
   m4type,BS,
    `{ m4angt = rp_ang; battery(up_ m4lcd*3/4 with .c at m4name.c)
       cross(at m4name.c+(m4lcd/4,m4lcd/5),m4lcd/6)
       line right_ m4lcd/6 with .c at m4name.c+(m4lcd/4,-m4lcd/6)
       point_(m4angt) }',
   m4type,StatG,
    `{ m4angt= rp_ang; pushdef(`dimen_',m4lcd*2)
       diode(right_ dimen_/6 with .c at m4name.c,DK)
       popdef(`dimen_') point_(m4angt)}')
   [ box invis wid_ m4lcd ht_ m4lcd ] at last circle }') dnl
 popdef(`m4type',`m4name', `m4lgth', `m4wdth', `m4box', `m4text')')

                            `sl_syncmeter( stem linespec, keys,
                                           breaker or Sn:slash )'
                                `default breaker name Br'
define(`sl_syncmeter',`sl_disk($@)
 { Syncsymb(at last circle)
   m4lcd = last circle.diam
   [ box invis wid_ m4lcd ht_ m4lcd ] at last circle } popdef(`m4thype')')

                            `sl_lamp( stem linespec, keys, breaker or Sn:slash)'
                                `default breaker name Br'
define(`sl_lamp',`sl_disk($@)
 { line from last circle.ne to last circle.sw
   line from last circle.nw to last circle.se
   m4lcd = last circle.diam
   [ box invis wid_ m4lcd ht_ m4lcd ] at last circle } ')

# One-terminal utilities ##################################################

                            `Syncsymb(at position, rad)
                                Symbol for sync meter'
define(`Syncsymb',`[ define(`m4ssrad',`ifelse(`$2',,(dimen_/4),`($2)')')dnl
 Origin: Here
 {arc <-> ht arrowht/2 wid arrowwid*2/3 \
   from Rect_(m4ssrad,30) to Rect_(m4ssrad,150) with .c at Here}
 line from (0,m4ssrad) to (0,-m4ssrad/2)
 `$3' ] with .Origin ifelse(`$1',,`at Here',`$1')')


                        `Windturbine(at position, keys, U|D|L|R|degrees)
                          keys: size=expr; color="color string"
                          Arg3: drawing direction (default: Right)'
define(`Windturbine',`[
 pushkeys_(`$2',`size:sl_diskdia_:;color:"black":N')dnl
 setdir_(`$3',R)
 C: Here; N: C
 circle diam m4size/18 at C colored m4color
 for t = 30 to 360 by 120 do {
 tr = t*dtor_
 spline 0.55 thick 0.2 shaded m4color outlined m4color \
  from M4wt(4,-0.8) to M4wt(1.810794,-0.921724)
 Loopover_(`M4LO',`continue to M4LO',
  M4wt(1.135237,-0.069654), M4wt(1.777783,1.339647),
  M4wt(4.198063,2.031772), M4wt(5.033839,2.04),
  M4wt(5.598904,2.029888), M4wt(17.372737,0.390951),
  M4wt(18.164674,0.024408), M4wt(17.639221,-0.537401), M4wt(4,-0.8)) }
 `$4'; resetdir_ popdef(`m4color',`m4size') ] ifelse(`$1',,`at Here',`$1')')
define(`M4wt',`(vec_(rot_(`$1',`$2',tr))*m4size/36)')

                            `sl_eleminit_(linespec or (for zero length)
                                U|D|L|R|number [at location])'
define(`sl_eleminit_',
`ifelse(regexp(`$1',^ *[UDLR0123456789]),-1,
  `eleminit_(`$1',dimen_)',
  `pushdef(`M4pos',`ifinstr(`$1',` at ',`patsubst(`$1',^.* at *)')')dnl
   ifelse(M4pos,,,`move to M4pos;') setdir_(patsubst(`$1',` at.*'))
  line invis from Here to Here popdef(`M4pos')')')

# Two-terminal elements ###################################################

                            `sl_transformer(linespec,
                               keys,
                               input breaker keys,
                               output breaker keys,
                               type S input circle inner object,
                               type S output circle inner object)
                             keys:
                               name=body name (default Body);
                               scale=expr; (body size factor: default 1)
                               type=I|S|A[R]
                               (type=I) cycles=n; (default 4)
                                        core= A[ir]|M[n]|P[n]|K[n]
                                              n=integer (default 2 lines)
                               (type=S) body=circle attributes;
                                        Note arg5 and arg6
                               (type=A) body=circle attributes ;
                                        type AR means right orientation
                               (breaker default names are BrI, BrO)
                             Args 3 and 4 specify input and output stem objects
                               (breakers or slash symbols);
                             Args 5 and 6 for the input and output circles are
                               name=symbol name; (optional)
                               Y for a Y symbol
                               YN for a Y symbol with ground
                                 Default name for a Y in arg5 is Body_Y1; in
                                   arg6 it is Body_Y2
                               Delta for a Delta symbol
                                 Default name for arg5 is Body_D1; in
                                   arg6 it is Body_D2
                               otherwise other customization commands in
                                 a {} pair.  '
define(`sl_transformer',
`pushkeys_(`$2',name:Body:N; type:I:N; cycles:4:N; core::N; body::N;
   scale:sl_transcale_; )define(`m4scf',(m4scale*1.3))dnl
 ifinstr(m4type,S,
  `define(`m4blgth',sourcerad_*3.5*m4scf)',
  m4type,A,
  `define(`m4blgth',sourcerad_*3*m4scf)',
  `ifelse(ifinstr(m4core,M,T,m4core,P,T,m4core,K,T),T,
    `define(`m4nL',ifelse(len(m4core),1,2,substr(m4core,1)))dnl
     define(`m4blgth',(dimen_/8 + dimen_/12 + (m4nL-1)*dimen_/16)*m4scf)',dnl
    `define(`m4blgth',(dimen_/8 + dimen_/12)*m4scf)')')dnl
 ifelse(`$3'`$4',,
  `ifinstr(m4type,S,
    `pushdef(`sourcerad_',sourcerad_*m4scf)dnl
     source(`$1',G,,,m4body,m4name); C: last [].c popdef(`sourcerad_')
     ifelse(`$5',,,`m4DY(`$5',, 1,m4name.C1,sl_diskdia_*0.18,rp_ang*rtod_)')
     ifelse(`$6',,,`m4DY(`$6',-,2,m4name.C2,sl_diskdia_*0.18,rp_ang*rtod_)')',
   m4type,A,
    `eleminit_(`$1'); C: last line.c
     { line to rvec_(rp_len/2-m4blgth/2,0); round
       pushdef(`m4R',ifinstr(m4type,R,-))dnl
      {m4name: [ C2: circle rad m4blgth/3 m4body at (0,0)
         Arc: arc ifinstr(m4type,R,c)`'cw \
           from C2-vec_(m4blgth/3*2,0) to C2+vec_(0,m4R`'m4blgth/3) \
            with .c at C2-vec_(0,m4R`'m4blgth/2) ] \
         with .C2 at rvec_(m4blgth/3*2,0)} popdef(`m4R')
     line from rvec_(m4blgth,0) to rvec_(rp_len/2+m4blgth/2,0) }
     line invis to rvec_(rp_len,0)',
    `eleminit_(`$1'); C: last line.c; m4atmp = rp_ang; m4slen = rp_len
     { line to rvec_((m4slen-m4blgth)/2,0)
       {m4name: [ linewid = linewid*m4scf
         {L1: inductor(to vec_(0,-m4cycles*dimen_/8),,m4cycles,m4core)}
         point_(m4atmp)
         L2: inductor(from vec_(m4blgth/m4scf,-m4cycles*dimen_/8) \
               to vec_(m4blgth/m4scf,0),,m4cycles)
         point_(m4atmp) ] with .L1.c at Here}
     line from rvec_(m4blgth,0) to rvec_((m4slen+m4blgth)/2,0) }
     line invis to rvec_(rp_len,0)')', 
  `m4_two(`sl_transformer',m4blgth,$@)')
 popdef(`m4name', `m4type', `m4cycles', `m4core', `m4body', `m4scale') ')
define(`m4trground',
`if pmod(drawdir_(`$1'),180)==0 then {
   line from `$2' to `$2'+(0,-sourcerad_*5/4*m4scf); ground(,T) } \
 else {
   line from `$2' to `$2'+(sourcerad_*3/2*m4scf,0); corner; ground } ')

                           `sl_transformer3(linespec,
                              keys,
                              breaker1:breaker2:breaker3,
                              symbol1:symbol2:symbol3)
                            keys:
                              name=Name;
                              type=S|C; (default S)
                              scale=expr;
                              direct=L|R;
                              body=circle attributes; '
define(`sl_transformer3',
`[ pushkeys_(`$2',name:Body:N; scale:sl_transcale_; direct:L:N; body::N;
     type:S:N )dnl
   ifelse(m4type,S,
    `m4trAr(`m4Br',patsubst(`$3',:,`,'))m4trAr(`m4Sy',patsubst(`$4',:,`,'))dnl
     pushdef(`sl_breakersep_',sl_breakersep_*2/3)dnl
     sl_transformer($1,type=S;name=m4name;scale=m4scale;$2,
       m4Br1,m4Br2,m4Sy1,m4Sy2)
     Tstart: last line.start; C1: m4name.C1; m4atmp = rp_ang
     Tend: last line.end;   C2: m4name.C2
     define(`m4R',`ifinstr(m4direct,R,-)')dnl
     C3: m4name.C1+vec_(Rect_(m4name.C1.rad*3/2,m4R`'60))
     move to C3+vec_(0,m4R`'m4name.C1.rad)
     Tc: rvec_(0,m4R`'m4name.C1.diam`'ifelse(m4Br3,,/3))
     sl_disk(from Tc to Here,
       diam=m4name.C1.diam;name=C3;circle=m4body;`$2',m4Br3)
     m4DY(m4Sy3,,3,C3,C3.diam*0.18,rp_ang*rtod_); popdef(`sl_breakersep_')
     point_(m4atmp)',
    `pushdef(`m4rad',`sl_diskdia_/6*m4scale')dnl
     eleminit_(`$1',m4rad*8)
     Tstart: Here
     line to rvec_(rp_len/2-m4rad*2,0); round
     Arc: arc cw to rvec_(m4rad*4,0) with .c at rvec_(m4rad*2,0)
     round; line to rvec_(rp_len/2-m4rad*2,0)
     Tend: Here
     C: circle rad m4rad at Arc.c
     line from C+vec_(0,-m4rad) to C+vec_(0,-m4rad*3)
     Tc: Here popdef(`m4rad') ')
   popdef(`m4name',`m4scale',`m4direct',`m4body',`m4type') ]')
define(`m4trAr',`define(`$1'`1',$2)define(`$1'`2',$3)define(`$1'`3',$4)')

                           `m4DY(symbol,neg,number,loc,size,angle)
                            Insert Delta or Y symbol'
define(`m4DY',
`pushkey_(`$1',name,m4name`'_`'ifinstr(`$1',Delta,D,Y)`$3',N)dnl
 define(`m4ang',``$6'`'ifelse(`$2',-,+180)')dnl
 define(`m4sn',m4name)popdef(`m4name')dnl
 ifinstr(`$1',Delta,
  `{m4sn: Deltasymbol(with .N at `$4',size=`$5',m4ang-180)} ',
 `$1',Y,
  `{m4sn:     Ysymbol(with .N at `$4',size=`$5',m4ang)}
   ifinstr(`$1',N,`{m4trground(m4ang,m4sn.N)}') ',
 `{`$1'}')')

                            `Two-terminal box'
                            `sl_ttbox(linespec,keys,breaker keys,breaker keys)
                             keys= lgth=expr; wdth=expr; box=attributes;
                               supp=additional rotbox commands;
                               name=body name (default Body);
                               text="text";
                               (breaker default names BrI, BrO)'
define(`sl_ttbox',
`pushkeys_(`$2',`lgth:sl_ttboxlen_; wdth:sl_ttboxwid_;
   name:Body:N; box::N; text::N; supp::N')dnl
 ifelse(`$3'`$4',,
  `eleminit_(`$1')
   {line to rvec_((rp_len-m4lgth)/2,0)
     {m4name: rotbox(m4lgth,m4wdth,m4box,,m4supp) \
       with .W at Here }
     ifelse(m4text,,,`{m4text at rvec_(m4lgth/2,0)};') dnl
    line from rvec_(m4lgth,0) to rvec_((rp_len+m4lgth)/2,0)}
   line invis to rvec_(rp_len,0) ',
  `m4_two(`sl_ttbox',m4lgth,$@)') dnl
 popdef(`m4lgth', `m4wdth', `m4name', `m4box', `m4text', `m4supp') ')

                            `sl_rectifier(ttbox args)'
define(`sl_rectifier',
`pushkeys_(`$2',`lgth:sl_ttboxlen_; wdth:sl_ttboxwid_; name:Body:N')dnl
 sl_ttbox($@)
 { line from m4name.ne to m4name.sw
   AC: ACsymbol(at m4name.c+(-m4lgth/6, m4wdth/4),,,R)
   DC: DCsymbol(at m4name.c+( m4lgth/6,-m4wdth/4),,,R) } dnl
 popdef(`m4lgth',`m4wdth',`m4name') ')

                            `sl_inverter(ttbox args)'
define(`sl_inverter',
`pushkeys_(`$2',`lgth:sl_ttboxlen_; wdth:sl_ttboxwid_; name:Body:N')dnl
 sl_ttbox($@)
 { line from m4name.ne to m4name.sw
   DC: DCsymbol(at m4name.c+(-m4lgth/6, m4wdth/4),,,R)
   AC: ACsymbol(at m4name.c+( m4lgth/6,-m4wdth/4),,,R) } dnl
 popdef(`m4lgth',`m4wdth',`m4name') ')

                            `m4_one( `elementname',
                               linespec (placeholder not used),
                               body keys,
                               breaker keys or S[n]: keys )'
                            `Draw the breaker slash in the element stem'
define(`m4_one',
`pushkeys_(`$4',lgth:sl_breakersize_; sep:-1)define(`m4s_p',`ifelse(m4sep,(-1),
  `pushkey_(`$3',sep,sl_breakersep_)`'m4sep`'popdef(`m4sep')',m4sep)')dnl
 M4end: last line.end
 {ifelse(regexp(`$4',^ *S),-1,
  `ifelse(`$4',,,
    `line to last line.end-vec_(m4lgth+m4s_p,0)
     pushdef(`m4bri',`ifelse(`$4',C,,`$4',O,`box=fill_(0)')')dnl
     sl_breaker(to rvec_(m4lgth,0),`$4';m4bri;name=Br) popdef(`m4bri')')
   $1(to M4end,`$3')',
  `{ $1(to M4end,`$3') }
   ifelse(`$4',,,
    `define(`m4in',`ifelse(`$4',S,1,`$4',S:,1,
      `patsubst(`$4',.*S\([0-9][0-9]*\):?.*,\1)')')dnl
     define(`m4inkey',`patsubst(`$4',^ *S[0-9]*:?)') pushkey_(m4inkey,name,SL,N)
     sl_slash(at M4end-vec_(m4lgth+m4s_p*2/3,0),
       m4inkey;name=m4name,m4in:) popdef(`m4name')')')}
   popdef(`m4lgth',`m4sep')')

                            `sl_breaker(linespec, type=[A|C][D]; ttbox keys)
                               C is for curved breaker
                               D is for sl_drawout with two chevrons
                               Default body name is Br'
define(`sl_breaker',
`pushkeys_(`$2',`lgth:sl_breakersize_; wdth:sl_breakersize_;
   name:Br:N; type:A:N')dnl
 ifinstr(ifinstr(m4type,CD,T,m4type,DC,T),T,
  `m4ch_two(`cbreaker',`$1',,,m4name)',
 m4type,C,
  `cbreaker(`$1',,,m4name)',
 m4type,D,
  `m4ch_two(`sl_ttbox',`$1',
     lgth=m4lgth;wdth=m4wdth;`$2'ifinstr(`$2',name=,;name=m4name))',
 `$2',X;,
  `sl_ttbox(`$1',supp=line from NW to SE
   line from NE to SW;lgth=m4lgth;wdth=m4wdth;`$2';name=m4name)',
 `$2',/;,
  `sl_ttbox(`$1',
   supp=line from SE to NW;lgth=m4lgth;wdth=m4wdth;`$2';name=m4name)',
 `$2',\;,
  `sl_ttbox(`$1',
   supp=line from NE to SW;lgth=m4lgth;wdth=m4wdth;`$2';name=m4name)',
 `sl_ttbox(`$1',lgth=m4lgth;wdth=m4wdth;`$2')' ) dnl
 popdef(`m4lgth', `m4wdth', `m4name', `m4type') ')

                            `sl_reactor(linespec,keys,breaker keys,breaker keys)
                             keys=
                               name=Name (body name, default Body);
                               diam=expr;
                             Default breakers BrI, BrO'
define(`sl_reactor',
`pushkeys_(`$2',`diam:sl_diskdia_*2/3;name:Body:N')dnl
 ifelse(`$3'`$4',,
  `eleminit_(`$1')
   { line to rvec_(rp_len/2,0) then to rvec_(rp_len/2,-m4diam/2); round
     arc rad m4diam/2 cw from Here to rvec_(m4diam/2,m4diam/2) \
       with .c at rvec_(0,m4diam/2); round
     line to rvec_(rp_len/2-m4diam/2,0) }
   {m4name: [ box invis ht m4diam wid m4diam ] at rvec_(rp_len/2,0)}
   line invis to rvec_(rp_len,0) ',
  `m4_two(`sl_reactor',m4diam,$@)') dnl
 popdef(`m4diam',`m4name') ')

                            `sl_drawout(linespec, keys, R)
                             Drawout (i.e. plugin) chevron element;
                               keys:  type=T; (truncated leads)
                                      lgth=expr; (body size)
                                      wdth=expr;
                                      name=Name; (body name)
                                      line= line attributes (e.g. thick 2)
                               arg3=R reverse direction'
define(`sl_drawout',
`pushkeys_(`$2',`lgth:sl_chevronsiz_; wdth:sl_chevronsiz_; type::N;
   name:Body:N; line::N')dnl
 eleminit_(`$1',ifelse(m4type,T,m4lgth))
 ifelse(`$3',R,`{M4ds: Here; move to last line.end; rp_ang = rp_ang+pi_')
 {line to rvec_(rp_len/2,0)
  m4name: [
   S: Here; {line from rvec_(-m4lgth/2,m4wdth/2) to Here then
     to rvec_(-m4lgth/2,-m4wdth/2) m4line }
   E: rvec_(m4lgth/2,0); line from rvec_(0,m4wdth/2) to E then
     to rvec_(0,-m4wdth/2) m4line ] with .S at Here
   ifelse(m4type,T,,
    line from last [].E to last [].E+vec_((rp_len-m4lgth)/2,0))}
  ifelse(`$3',R,`rp_ang = rp_ang-pi_; move to M4ds}')
 line invis to rvec_(rp_len,0) dnl
 popdef(`m4lgth', `m4wdth', `m4type', `m4name', `m4line') ')

# Two-terminal utilities ##################################################

                            `Breakers or slashes in the input and output lines:
                            `m4_two(`2-term element macroname in quotes',
                               body length,
                               linespec,
                               body keys,
                               [Sn:] input breaker or slash keys,
                               [Sn:] output breaker or slash keys)'
                             In args 5 and 6 a prefix S: or Sn: draws slashes
                             (Default breaker names are BrI and BrO)
                             (Default slash names are SLI and SLO)'
define(`m4_two',
`pushkeys_(`$4',lgth:ifelse(`$2',,sl_ttboxlen_*2,`$2'); sep:-1)dnl
 define(`m4s_pI',`ifelse(m4sep,(-1),
  `pushkey_(`$5',sep,sl_breakersep_) m4sep popdef(`m4sep')',m4sep)')dnl
 define(`m4s_pO',`ifelse(m4sep,(-1),
  `pushkey_(`$6',sep,sl_breakersep_) m4sep popdef(`m4sep')',m4sep)')dnl
 ifelse(regexp(`$5',^ *S),-1,
  `define(`m4il',`ifelse(`$5',,0,
    `pushkeys_(`$5',lgth:sl_breakersize_) m4lgth popdef(`m4lgth')')')dnl
   define(`m4ol',`ifelse(`$6',,0,
    `pushkey_(`$6',lgth,sl_breakersize_) m4lgth popdef(`m4lgth')')')dnl
   eleminit_(`$3',max(elen_,m4lgth+m4il*3.5+m4ol*3.5+m4s_pI+m4s_pO))
   M4end: last line.end
   { line to last line.c-vec_((m4lgth + m4il + m4ol + m4s_pI+m4s_pO)/2,0)
     pushdef(`m4bri',`ifelse(`$5',,,`$5',C,,`$5',O,`box=fill_(0)')')dnl
     ifelse(`$5',,,`sl_breaker(to rvec_(m4il,0),`$5';m4bri;name=BrI)
       line to rvec_(m4s_pI,0)')
     $1(to rvec_(m4lgth,0),`$4',,,`$7',`$8')
     pushdef(`m4bro',`ifelse(`$6',,,`$6',C,,`$6',O,`box=fill_(0)')')dnl
     ifelse(`$6',,,`line to rvec_(m4s_pO,0)
       sl_breaker(to rvec_(m4ol,0),`$6';m4bro;name=BrO)')
     line to M4end popdef(`m4bri', `m4bro') }',
  `eleminit_(`$3',max(elen_,m4lgth+(m4s_pI+m4s_pO)*2)) ; dnl slashes
   M4end: last line.end
   { $1(to M4end,`$4',,,`$7',`$8') }
   ifelse(`$5',,,`define(`m4in',`ifelse(`$5',S,1,`$5',S:,1,
      `patsubst(`$5',.*S\([0-9][0-9]*\):?.*,\1)')')dnl
     define(`m4inkey',`patsubst(`$5',^ *S[0-9]*:?)')dnl
     pushkey_(m4inkey,name,SLI,N)dnl
     {sl_slash(at rvec_(rp_len/2-m4lgth/2-m4s_pI,0),
       m4inkey;name=m4name,m4in:)} popdef(`m4name')')
   ifelse(`$6',,,`define(`m4on',`ifelse(`$6',S,1,`$6',S:,1,
      `patsubst(`$6',.*S\([0-9][0-9]*\):*.*,\1)')')dnl
     define(`m4onkey',`patsubst(`$6',^ *S[0-9]*:?)')dnl
     pushkey_(m4onkey,name,SLO,N)dnl
     {sl_slash(at rvec_(rp_len/2+m4lgth/2+m4s_pO,0),
       m4onkey;name=m4name,m4on:)} popdef(`m4name')') ')
   line invis to M4end popdef(`m4lgth', `m4sep') ')

                            `Chevrons in the input and output lines:'
                            `m4ch_two(`2-term element macroname in quotes',
                                linespec,
                                body keys)'
define(`m4ch_two',
`define(`m4bl',`setkey_(`$3',lgth,dimen_*3/8) m4lgth')popdef(`m4lgth')dnl
 eleminit_(`$2',dimen_*2)
 M4start: Here; M4end: last line.end
 M4elem: $1(to rvec_(m4bl+2*sl_chevronsiz_,0) with .c at last line.c,`$3')
 sl_drawout(from last line.start-vec_(sl_chevronsiz_,0) to last line.start,
   type=T,R)
 line from last line.start to M4start
 sl_drawout(from M4elem.end to M4elem.end+vec_(sl_chevronsiz_,0),type=T)
 line to M4end
 line invis from M4start to M4end')

# Composite elements ###################################################

                            `sl_ct( at position, keys, R|L|U|D|degrees )
                               keys:
                                type=L|N|S[n] (default L;
                                  Sn draws n slashes, default 2)
                                scale=expr (default 1);
                                grnd=degrees (type S or N);
                                stemlgth=expr (type L or S);
                                sep=expr (type S slashes to head separation);
                               type=N omits the stem and slashes
                               type=Sn draws n slashes, e.g., type=S2
                               Arg3 sets the stem direction'
define(`sl_ct',`[ Origin: Here
 pushkeys_(`$2', type:L:N; scale:1; grnd::N ) dnl
 define(`m4scf',`(m4scale*1.2)')dnl
 setdir_(`$3',R)
 ifinstr(m4type,L,`define(`m4lw',`dimen_/8*m4scf')dnl
   L: inductor(to vec_(2*m4lw,0) with .c at Origin,,2,,m4lw); C: L.c
     pushkey_(`$2',stemlgth,dimen_/5)dnl
     line from L.start to L.start+vec_(0,-m4stemlgth)
   Tstart: Here
     line from L.end to L.end+vec_(0,-m4stemlgth)
   Tend: Here
     line from L.c to L.c+vec_(0,-m4stemlgth)
   Tc: Here popdef(`m4stemlgth')',
 m4type,S,
  `C: circle rad sourcerad_*m4scale*0.5 at Origin
   pushkeys_(`$2',stemlgth:C.rad*6; sep:C.rad*2)dnl
   Stem: line from C to C+vec_(m4stemlgth,0) chop C.rad chop 0; Tc: Here
   ifelse(m4grnd,,,`ground(at C+(Rect_(C.rad,m4grnd)),,,m4grnd)'); \
   pushdef(`m4n',`ifelse(m4type,S,2,`eval(patsubst(m4type,.*S))')')dnl
   sl_slash(at C+vec_(C.rad+m4sep,0),,m4n:rp_ang*rtod_)
   popdef(`m4stemlgth',`m4sep',`m4n')',
 m4type,N,
  `C: circle rad sourcerad_*m4scale*0.5 at Origin
   ifelse(m4grnd,,,`ground(at C+(Rect_(C.rad,m4grnd)),,,m4grnd)') ')
 resetdir_ popdef(`m4type', `m4scale', `m4grnd' )
 ] with .Origin ifelse(`$1',,at Here,`$1') ')

                            `sl_busbar( linespec, np, keys )
                             Labels P1, P2 ... Pnp are defined on the line.
                                  keys: line=line attributes;
                                        port=D; (dotted ports)
                                        indent=expr;
                                         (distance of points from Start and End)
                             The bus extends beyond the first and last points
                             by the indent value (default) sl_busindent_'
define(`sl_busbar',
 `define(`m4npoints',`ifelse(`$2',,2,`$2')')dnl
  pushkeys_(`$3',`line:thick sl_busthick_:N; port::N; indent:sl_busindent_')dnl
  [ tmp_ang = rp_ang
    eleminit_(`$1',(m4npoints-1)*dimen_)
    Start: last line.start; End: last line.end
    Line: line from Start to End m4line; C: Line.c
    M: move from Start to End chop m4indent
    for_(1,m4npoints,1,
     `P`'m4x: (m4x-1)/(m4npoints-1) between M.start and M.end dnl
     ifinstr(m4port,D,` ;dot(at P`'m4x)')')
    point_(tmp_ang) ] popdef(`m4line', `m4port', `m4indent') ')

                          `sl_slash( at position, keys, [n:]R|L|U|D|degrees)
                           keys:
                             lines=line attributes;
                             size=expr (default ht dimen_/3); '
define(`sl_slash',`[ C: Here
 pushkeys_(`$2',lines::N; size:dimen_/3 )dnl
 define(`m4nsl',`ifelse(`$3',,1,`ifinstr(`$3',:,patsubst(`$3',:.*),1)')')dnl
 pushdef(`m4ACd',`ifinstr(`$3',:,`patsubst(`$3',.*:)',`$3')')dnl
 setdir_(ifelse(m4ACd,,`ifdef(`m4a_',rp_ang*rtod_,0)',m4ACd))
 dx = m4size/2.5
 for_(1,m4nsl,1, `{ line to vec_(m4size/sqrt(3),m4size) m4lines \
   with .c at C+vec_((m4x-(1+m4nsl)/2)*dx,0) } ')
 resetdir_ popdef(`m4lines', `m4size',`m4ACd')
 `$8' ] ifelse(`$1',,at Here,`$1')')
  
# #######################################################################

divert(0)dnl
