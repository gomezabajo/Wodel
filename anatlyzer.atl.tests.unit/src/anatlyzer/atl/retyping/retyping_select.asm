<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="retypingselect"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchmodel():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="elements"/>
		<constant value="B"/>
		<constant value="J.oclIsKindOf(J):J"/>
		<constant value="B.not():B"/>
		<constant value="26"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="propOfB"/>
		<constant value="J.isEmpty():J"/>
		<constant value="56"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="8:3-8:6"/>
		<constant value="8:3-8:15"/>
		<constant value="8:28-8:29"/>
		<constant value="8:42-8:48"/>
		<constant value="8:28-8:49"/>
		<constant value="8:3-8:51"/>
		<constant value="8:65-8:66"/>
		<constant value="8:65-8:74"/>
		<constant value="8:3-8:76"/>
		<constant value="8:3-8:87"/>
		<constant value="10:10-13:3"/>
		<constant value="b"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="default"/>
		<constant value="11:14-11:23"/>
		<constant value="11:6-11:23"/>
		<constant value="12:18-12:21"/>
		<constant value="12:18-12:30"/>
		<constant value="12:6-12:30"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="46"/>
			<push arg="47"/>
			<findme/>
			<push arg="48"/>
			<call arg="49"/>
			<iterate/>
			<store arg="19"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<get arg="50"/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<push arg="51"/>
			<push arg="47"/>
			<findme/>
			<call arg="52"/>
			<call arg="53"/>
			<if arg="54"/>
			<load arg="29"/>
			<call arg="55"/>
			<enditerate/>
			<iterate/>
			<store arg="29"/>
			<load arg="29"/>
			<get arg="56"/>
			<call arg="55"/>
			<enditerate/>
			<call arg="57"/>
			<call arg="53"/>
			<if arg="58"/>
			<getasm/>
			<get arg="1"/>
			<push arg="59"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="60"/>
			<dup/>
			<push arg="61"/>
			<load arg="19"/>
			<pcall arg="62"/>
			<dup/>
			<push arg="63"/>
			<push arg="46"/>
			<push arg="64"/>
			<new/>
			<pcall arg="65"/>
			<pusht/>
			<pcall arg="66"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="67" begin="13" end="13"/>
			<lne id="68" begin="13" end="14"/>
			<lne id="69" begin="17" end="17"/>
			<lne id="70" begin="18" end="20"/>
			<lne id="71" begin="17" end="21"/>
			<lne id="72" begin="10" end="26"/>
			<lne id="73" begin="29" end="29"/>
			<lne id="74" begin="29" end="30"/>
			<lne id="75" begin="7" end="32"/>
			<lne id="76" begin="7" end="33"/>
			<lne id="77" begin="48" end="53"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="16" end="25"/>
			<lve slot="2" name="78" begin="28" end="31"/>
			<lve slot="1" name="61" begin="6" end="55"/>
			<lve slot="0" name="17" begin="0" end="56"/>
		</localvariabletable>
	</operation>
	<operation name="79">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="80"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="61"/>
			<call arg="81"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="63"/>
			<call arg="82"/>
			<store arg="83"/>
			<load arg="83"/>
			<dup/>
			<getasm/>
			<push arg="84"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="50"/>
			<call arg="30"/>
			<set arg="50"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="85" begin="11" end="11"/>
			<lne id="86" begin="9" end="13"/>
			<lne id="87" begin="16" end="16"/>
			<lne id="88" begin="16" end="17"/>
			<lne id="89" begin="14" end="19"/>
			<lne id="77" begin="8" end="20"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="63" begin="7" end="20"/>
			<lve slot="2" name="61" begin="3" end="20"/>
			<lve slot="0" name="17" begin="0" end="20"/>
			<lve slot="1" name="90" begin="0" end="20"/>
		</localvariabletable>
	</operation>
</asm>
