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
		<constant value="A.__matcha2model():V"/>
		<constant value="__exec__"/>
		<constant value="model"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applymodel(NTransientLink;):V"/>
		<constant value="a2model"/>
		<constant value="A.__applya2model(NTransientLink;):V"/>
		<constant value="__matchmodel"/>
		<constant value="Model"/>
		<constant value="ABCD"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="aX"/>
		<constant value="X"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="6:10-11:6"/>
		<constant value="11:8-13:3"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="4"/>
		<constant value="test"/>
		<constant value="Set"/>
		<constant value="CJ.including(J):CJ"/>
		<constant value="elements"/>
		<constant value="J.union(J):J"/>
		<constant value="7:14-7:20"/>
		<constant value="7:6-7:20"/>
		<constant value="9:24-9:26"/>
		<constant value="9:18-9:28"/>
		<constant value="9:37-9:40"/>
		<constant value="9:37-9:49"/>
		<constant value="9:18-9:51"/>
		<constant value="9:6-9:51"/>
		<constant value="12:11-12:15"/>
		<constant value="12:3-12:15"/>
		<constant value="link"/>
		<constant value="__matcha2model"/>
		<constant value="30:10-32:3"/>
		<constant value="__applya2model"/>
		<constant value="will provoke a problem"/>
		<constant value="31:14-31:38"/>
		<constant value="31:6-31:38"/>
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
			<getasm/>
			<pcall arg="41"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="49"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<pcall arg="54"/>
			<dup/>
			<push arg="55"/>
			<load arg="19"/>
			<pcall arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="49"/>
			<push arg="58"/>
			<new/>
			<pcall arg="59"/>
			<dup/>
			<push arg="60"/>
			<push arg="61"/>
			<push arg="58"/>
			<new/>
			<pcall arg="59"/>
			<pusht/>
			<pcall arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="63" begin="19" end="24"/>
			<lne id="64" begin="25" end="30"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="55" begin="6" end="32"/>
			<lve slot="0" name="17" begin="0" end="33"/>
		</localvariabletable>
	</operation>
	<operation name="65">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="55"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="68"/>
			<store arg="70"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<push arg="71"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<push arg="72"/>
			<push arg="8"/>
			<new/>
			<load arg="70"/>
			<call arg="73"/>
			<load arg="29"/>
			<get arg="74"/>
			<call arg="75"/>
			<call arg="30"/>
			<set arg="74"/>
			<pop/>
			<load arg="70"/>
			<dup/>
			<getasm/>
			<push arg="60"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="76" begin="15" end="15"/>
			<lne id="77" begin="13" end="17"/>
			<lne id="78" begin="23" end="23"/>
			<lne id="79" begin="20" end="24"/>
			<lne id="80" begin="25" end="25"/>
			<lne id="81" begin="25" end="26"/>
			<lne id="82" begin="20" end="27"/>
			<lne id="83" begin="18" end="29"/>
			<lne id="63" begin="12" end="30"/>
			<lne id="84" begin="34" end="34"/>
			<lne id="85" begin="32" end="36"/>
			<lne id="64" begin="31" end="37"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="57" begin="7" end="37"/>
			<lve slot="4" name="60" begin="11" end="37"/>
			<lve slot="2" name="55" begin="3" end="37"/>
			<lve slot="0" name="17" begin="0" end="37"/>
			<lve slot="1" name="86" begin="0" end="37"/>
		</localvariabletable>
	</operation>
	<operation name="87">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="6"/>
			<push arg="50"/>
			<findme/>
			<push arg="51"/>
			<call arg="52"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="53"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<pcall arg="54"/>
			<dup/>
			<push arg="55"/>
			<load arg="19"/>
			<pcall arg="56"/>
			<dup/>
			<push arg="57"/>
			<push arg="49"/>
			<push arg="58"/>
			<new/>
			<pcall arg="59"/>
			<pusht/>
			<pcall arg="62"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="88" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="55" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="89">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="66"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="55"/>
			<call arg="67"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="57"/>
			<call arg="68"/>
			<store arg="69"/>
			<load arg="69"/>
			<dup/>
			<getasm/>
			<push arg="90"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="9" end="13"/>
			<lne id="88" begin="8" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="57" begin="7" end="14"/>
			<lve slot="2" name="55" begin="3" end="14"/>
			<lve slot="0" name="17" begin="0" end="14"/>
			<lve slot="1" name="86" begin="0" end="14"/>
		</localvariabletable>
	</operation>
</asm>
