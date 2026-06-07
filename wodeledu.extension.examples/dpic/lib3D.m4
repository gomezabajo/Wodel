divert(-1)
lib3D.m4                        Macros for rotation, projection, and other
                                operations on argument triples representing
                                3D vectors or colors.

* Circuit_macros Version 11.0.4, copyright (c) 2026 J. D. Aplevich under     *
* the LaTeX Project Public Licence in file Licence.txt. The files of       *
* this distribution may be redistributed or modified provided that this    *
* copyright notice is included and provided that modifications are clearly *
* marked to distinguish them from this distribution.  There is no warranty *
* whatsoever for these files.                                              *

define(`lib3D_')
ifdef(`libgen_',,`include(libgen.m4)divert(-1)')

=============================================================================

                               `setview(azimuth, elevation, rotation)
                                Set view angles (degrees) for projection onto
                                a plane. The view vector is obtained by looking
                                in along the x axis, then rotating about -x,
                                -y, and z in that order. 3D vectors are
                                projected onto the resulting yz plane 
                                using the project() macro.  If rotation = 0, 
                                the projection matrix P is
                                P =(       -sin(az),        cos(az),   0   )
                                   (-sin(el)cos(az),-sin(az)sin(el),cos(el))'
define(`setview',`
`# setview($@)'
define(`m4azim',ifelse(`$1',,0,prod_($1,dtor_)))dnl
define(`m4elev',ifelse(`$2',,0,prod_($2,dtor_)))dnl
define(`m4rot', ifelse(`$3',,0,prod_($3,dtor_)))dnl
define(`m4azimr',`ifelse(`$1',,0,`prod_(`$1',dtor_)')')dnl
define(`m4elevr',`ifelse(`$2',,0,`prod_(`$2',dtor_)')')dnl
define(`m4rotx',`ifelse(`$3',,0,`prod_(`$3',dtor_)')')dnl
define(`m4caz',
 `ifelse(`$1',,1,`$1',0,1,`$1',90,0,`$1',-90, 0,m4cos(m4azim))')dnl
define(`m4saz',
 `ifelse(`$1',,0,`$1',0,0,`$1',90,1,`$1',-90,-1,m4sin(m4azim))')dnl
define(`m4cel',
 `ifelse(`$2',,1,`$2',0,1,`$2',90,0,`$2',-90, 0,m4cos(m4elev))')dnl
define(`m4sel',
 `ifelse(`$2',,0,`$2',0,0,`$2',90,1,`$2',-90,-1,m4sin(m4elev))')dnl
define(`m4cro',`ifelse(`$3',,1,`$3',0,1,`$3',90,0,`$3',-90, 0,m4cos(m4rot))')dnl
define(`m4sro',`ifelse(`$3',,0,`$3',0,0,`$3',90,1,`$3',-90,-1,m4sin(m4rot))')dnl
  view3D1=m4caz*m4cel;dnl
  view3D2=m4saz*m4cel;dnl
  view3D3=m4sel
  ifdef(`setlight_',,`light3D1=view3D1; light3D2=view3D2; light3D3=view3D3')
dnl                             Unit vectors projected on the view plane
  UPx_: project(1,0,0)
  UPy_: project(0,1,0)
  UPz_: project(0,0,1)
`# setview end'
')
define(`m4cos',`ifelse(`$1',0,1,cos(`$1'))')
define(`m4sin',`ifelse(`$1',0,0,sin(`$1'))')

                                The resulting view vector
#efine(`View3D',`PtoBase3D(1,0,0)')
define(`View3D',`view3D1,view3D2,view3D3')

                              `Extract the x-y, x-z, or y-z coordinate pair
                               from a triple'
define(`Pr_xy',`$1,$2')
define(`Pr_xz',`$1,$3')
define(`Pr_yz',`$2,$3')

                               Projection coords back to orig 3D coords
define(`PtoBase3D',
 `rot3Dz(m4azim,rot3Dy(-m4elev,rot3Dx(-m4rot,`$1',`$2',`$3')))')

                               This does the 3D to 2D axonometric projection
                               i.e. project(x,y,z) produces coordinate pair
                               u,v on the 2D plane defined by the view angles
                               and Project(x,y,z) produces position (u,v)
ifdpic(
`define(`project',
 `Pr_yz(rot3Dx(m4rot,rot3Dy(m4elev,rot3Dz(-m4azim,`$1',`$2',`$3'))))')
 define(`Project',`(ifelse(`$1',0,
 `ifelse(`$2',0,`ifelse(`$3',0,`(0,0)',UPz_*(`$3'))',
                `UPy_*(`$2')`'ifelse(`$3',0,,+UPz_*(`$3'))')',
 `UPx_*(`$1')`'ifelse(`$2',0,,+UPy_*(`$2'))`'ifelse(`$3',0,,+UPz_*(`$3'))'))')',
`define(`project',
 `Pr_yz(rot3Dx(m4rot,rot3Dy(m4elev,rot3Dz(-m4azim,`$1',`$2',`$3'))))')
 define(`Project',`(project($@))')')

                               `Rotation about x axis rot3Dx(angle,x1,x2,x3)'
define(`rot3Dx',``$2',diff_(prod_(m4cos(`$1'),`$3'),prod_(m4sin(`$1'),`$4')),dnl
 sum_(prod_(m4sin(`$1'),`$3'),prod_(m4cos(`$1'),`$4'))')

                               `Rotation about y axis rot3Dy(angle,x1,x2,x3)'
define(`rot3Dy',`sum_(prod_(m4cos(`$1'),`$2'),prod_(m4sin(`$1'),`$4')),`$3',dnl
 diff_(prod_(m4cos(`$1'),`$4'),prod_(m4sin(`$1'),`$2'))')

                               `Rotation about z axis rot3Dz(angle,x1,x2,x3)'
define(`rot3Dz',`diff_(prod_(m4cos(`$1'),`$2'),prod_(m4sin(`$1'),`$3')),dnl
 sum_(prod_(m4sin(`$1'),`$2'),prod_(m4cos(`$1'),`$3')),`$4'')

                               `Cross product cross3D(x1,y1,z1,x2,y2,z2)'
define(`cross3D',`diff_(prod_(`$2',`$6'),prod_(`$3',`$5')),dnl
 diff_(prod_(`$3',`$4'),prod_(`$1',`$6')),dnl
 diff_(prod_(`$1',`$5'),prod_(`$2',`$4'))')
  
                               `Dot product dot3D(x1,y1,z1,x2,y2,z2)'
define(`dot3D',`(sum_(
 sum_(prod_(`$1',`$4'),prod_(`$2',`$5')),prod_(`$3',`$6')))')
                                Vector addition, subtraction, scalar product
define(`sum3D',`sum_(`$1',`$4'),sum_(`$2',`$5'),sum_(`$3',`$6')')
define(`diff3D',`diff_(`$1',`$4'),diff_(`$2',`$5'),diff_(`$3',`$6')')
define(`sprod3D',`prod_(`$1',`$2'),prod_(`$1',`$3'),prod_(`$1',`$4')')
                                Extract direction cosine
                               `eg v = dcosine3D(1,x,y,z) assigns x to v' 
define(`dcosine3D',`(ifelse(`$1',1,`$2',`$1',2,`$3',`$4'))')
                                Euclidian length
define(`length3D',`sqrt((`$1')^2+(`$2')^2+(`$3')^2)')
                                Unit vector
define(`unit3D',`sprod3D(1/length3D(`$1',`$2',`$3'),`$1',`$2',`$3')')
                                Proportion: between3D(x,Vec1,Vec2), i.e.
                                Vec1 * (1-x) + Vec2 * x
define(`between3D',`sum3D(sprod3D((1-(`$1')),`$2',`$3',`$4'),
                          sprod3D(      `$1',`$5',`$6',`$7'))')

                               `assign3D([u],[v],[w],x,y,z); eg
                                assign3D(u,v,w,cross3D(x1,y1,z1,x2,y2,z2))
                                assigns u = 4th arg, v = 5th arg, w = 6th arg,
                                for nonblank u, v, or w'
define(`assign3D',`assign3($@)')

                               `vassign3D(name,x,y,z); eg
                                vassign3D(u,x,y,z)
                                assigns u[1] = x, u[2] = y, u[3] = z'
define(`vassign3D',`for i_vassign3D = 1 to 3 do {
  exec sprintf("`$1'[i_vassign3D] = $%g",i_vassign3D+3) }')
                                
                                Write out the 3 arguments for debug
define(`print3D',`print sprintf("`$1'(%g,%g,%g)",`$2',`$3',`$4')')

                               `setlight (azimuth, elevation, rotation)
                                Set angles (degrees) for 3D highlighting.
                                Defaults are the previous values for
                                setview().  The Light3D vector is defined
                                as for View3D.'
define(`setlight',`define(`setlight_')
 define(`m4hzim',`ifelse(`$1',,m4azimr,`prod_(`$1',dtor_)')')dnl
 define(`m4hlev',`ifelse(`$2',,m4elevr,`prod_(`$2',dtor_)')')dnl
 define(`m4hot',`ifelse(`$3',,m4rotx,`prod_(`$3',dtor_)')')dnl
 define(`m4chz',`ifelse(`$1',0,1,`$1',90,0,`$1',-90, 0,cos(m4hzim))')dnl
 define(`m4shz',`ifelse(`$1',0,0,`$1',90,1,`$1',-90,-1,sin(m4hzim))')dnl
 define(`m4chl',`ifelse(`$2',0,1,`$2',90,0,`$2',-90, 0,cos(m4hlev))')dnl
 define(`m4shl',`ifelse(`$2',0,0,`$2',90,1,`$2',-90,-1,sin(m4hlev))')dnl
 define(`m4cho',`ifelse(`$3',0,1,`$3',90,0,`$3',-90, 0,cos(m4hot))')dnl
 define(`m4sho',`ifelse(`$3',0,0,`$3',90,1,`$3',-90,-1,sin(m4hot))')dnl
 light3D1=m4chz*m4chl
 light3D2=m4shz*m4chl
 light3D3=m4shl
')
                                The resulting vector
#efine(`Light3D',`PtoBase3D(1,0,0)')
define(`Light3D',
 `ifdef(`setlight_',`light3D1,light3D2,light3D3',`view3D1,view3D2,view3D3')')

                                `Fector(x,y,z,nx,ny,nz) with .Origin at pos
                                Arrow with flat 3D head.  The second vector,
                                (i.e. args nx,ny,nz) is the normal to the
                                head flat surface'
define(`Fector',
 `[ Origin: 0,0
  define(`M4F_V',``$1',`$2',`$3'')dnl          the whole vector V
  lV = length3D(M4F_V)
  define(`M4F_T',``$4',`$5',`$6'')dnl          normal to the top surface
  lT = length3D(M4F_T)
  define(`M4F_Vn',`sprod3D(1/lV,M4F_V)')dnl  unit vector Vn
  aln = 0.15*scale ;dnl             arrowhead length
  awd = 0.09*scale ;dnl                 "     width
  adp = 0.0375*scale ;dnl               "     depth (thickness)
  define(`M4F_Vt',`sprod3D((lV-aln),M4F_Vn)')dnl head base vector

Start: Origin
End: project(M4F_V)
  rpoint_(from Origin to End)
  lTdp = adp/2/lT
  vtx = dcosine3D(1,M4F_Vt); vty = dcosine3D(2,M4F_Vt) # Vt coords
  vtz = dcosine3D(3,M4F_Vt)
dnl                             half-thickness vector in direction of T
  tx = prod_(lTdp,`$4'); ty = prod_(lTdp,`$5')
  tz = prod_(lTdp,`$6')
dnl                             half-width vector right
  rf = awd/2/lT/lV
  rx = rf*dcosine3D(1,cross3D(M4F_V,M4F_T))
  ry = rf*dcosine3D(2,cross3D(M4F_V,M4F_T))
  rz = rf*dcosine3D(3,cross3D(M4F_V,M4F_T))
dnl                             top and bottom points of V
TV: project(sum3D(M4F_V, tx,ty,tz))
BV: project(diff3D(M4F_V, tx,ty,tz))
dnl                             top, bottom right, left of base
TR: project(sum3D(vtx,vty,vtz, sum3D(tx,ty,tz,rx,ry,rz)))
BR: project(sum3D(vtx,vty,vtz, diff3D(rx,ry,rz,tx,ty,tz)))
BL: project(diff3D(vtx,vty,vtz, sum3D(rx,ry,rz,tx,ty,tz)))
TL: project(diff3D(vtx,vty,vtz, diff3D(rx,ry,rz,tx,ty,tz)))
  lthickness = linethick
dnl                             base
  if dot3D(M4F_V,View3D) < 0 then {
    thinlines_
    ifgpic(`gshade(0.5,BR,BL,TL,TR,BR,BL)',
     `line thick 0 fill_(0.5) from BR to BL then to TL then to TR then to BR')
    line from BR to BL ; line to TL ; line to TR ; line to BR
    linethick_(lthickness)
    }
dnl                             shaft
  linethick_(1.2)
  psset_(arrows=c-c)
  line from Origin to project(vtx,vty,vtz)
  psset_(arrows=-)
  thinlines_
dnl                             top or bottom
  if dot3D(M4F_T,View3D) > 0 then {
    ifgpic(`gshade(1,TR,TL,TV,TR,TL)',
     `line thick 0 fill_(1) from TV to TR then to TL then to TV')
    line from TV to TR ; line to TL ; line to TV
  } else {
    ifgpic(`gshade(0,BR,BL,BV,BR,BL)',
     `line thick 0 fill_(0) from BV to BR then to BL then to BV')
    line from BV to BR ; line to BL ; line to BV
    }
dnl                             starboard normal; draw right face
define(`M4F_S',
  `cross3D(diff3D(sprod3D(aln,M4F_Vn),rx,ry,rz),M4F_T)')dnl
  if dot3D(M4F_S,View3D) > 0 then {
    ifgpic(`gshade(1,TV,BV,BR,TR,TV,BV)',
     `line thick 0 fill_(1) from TV to BV then to BR then to TR then to TV')
    line from TV to BV ; line to BR ; line to TR ; line to TV
    }
dnl                             port normal; draw left face
define(`M4F_P',
  `cross3D(M4F_T,sum3D(sprod3D(aln,M4F_Vn),rx,ry,rz))')dnl
  if dot3D(M4F_P,View3D) > 0 then {
    ifgpic(`gshade(1,TV,BV,BL,TL,TV,BV)',
     `line thick 0 fill_(1) from TV to BV then to BL then to TL then to TV')
    line from TV to BV ; line to BL ; line to TL ; line to TV
    }
  linethick_(lthickness)
  `$7'] ') # End Fector

                               `shadedball( rad,
                                  highlight rad, highlight degrees,
                                  initial gray, final gray | (rf,gf,bf) )
                                The highlight is by default at
                                radius rad*3/5 and angle 110 deg
                                (or arg2 deg); if setlight has been
                                invoked then its azimuth and elevation arguments
                                determine highlight position.
                                Arg5 can be a parenthesized rgb color '
define(`shadedball',`[ C: (0,0);  r = ifelse(`$1',,circlerad,`$1')
  ifdef(`setlight_',
   `H: (project(sprod3D(r,light3D1,light3D2,light3D3)))
    hr = distance(C,H)',
   `hr = ifelse(`$2',,r*3/5,`$2'); ha = ifelse(`$3',,110,`$3')
    H: (cosd(ha)*hr,sind(ha)*hr)')
  rgbtohsv(ifelse(`$4',,`1,1,1',``$4',`$4',`$4''),h0,s0,v0)
  pushdef(`rgbf',`ifelse(`$5',,`(0.25,0.25,0.25)pushdef(`oneshade',1)',
    substr(`$5',0,1)substr(`$5',decr(len(`$5')),1),(),`$5'pushdef(`oneshade',0),
    `(`$5',`$5',`$5')pushdef(`oneshade',1)')')
  rgbtohsv(patsubst(rgbf,`^ *('\|`) *$'),hf,sf,vf)
  rm = r+hr; n = int(rm/(linethick bp__))
  for i=1 to n-1 do { x = i/n*rm; ifelse(oneshade,1,
     `hs = h0+(i/n)^2*(hf-h0); ss = s0+(i/n)^2*(sf-s0); vs = v0+(i/n)^2*(vf-v0)
      hsvtorgb(hs,ss,vs,ri,gi,bi)',
     `hsvtorgb(hf,(i/n)^2,vf,ri,gi,bi)')
    if x <= (r-hr) then {
      circle rad x thick linethick*1.6 outlined rgbstring(ri,gi,bi) at H } \
    else { arc cw thick linethick*ifpgf(2,1.6) outlined rgbstring(ri,gi,bi) \
      from Cintersect(H,x,C,r) to Cintersect(H,x,C,r,R) with .c at H } }
  circle rad r ifpgf(+linethick bp__/2) outlined rgbstring(ri,gi,bi) at C
  `$6' popdef(`rgbf',`oneshade') ]')

divert(0)dnl
