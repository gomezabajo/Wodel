<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="testnumberlogicalsuccess"/>
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
		<constant value="J.=(J):J"/>
		<constant value="1.5"/>
		<constant value="J.and(J):J"/>
		<constant value="J.&gt;(J):J"/>
		<constant value="a"/>
		<constant value="J.&lt;&gt;(J):J"/>
		<constant value="B.not():B"/>
		<constant value="56"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="src"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="tgt"/>
		<constant value="WXYZ"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="8:3-8:4"/>
		<constant value="8:7-8:8"/>
		<constant value="8:3-8:8"/>
		<constant value="9:3-9:4"/>
		<constant value="9:7-9:10"/>
		<constant value="9:3-9:10"/>
		<constant value="8:3-9:10"/>
		<constant value="10:3-10:6"/>
		<constant value="10:9-10:10"/>
		<constant value="10:3-10:10"/>
		<constant value="8:3-10:10"/>
		<constant value="11:3-11:6"/>
		<constant value="11:9-11:10"/>
		<constant value="11:3-11:10"/>
		<constant value="8:3-11:10"/>
		<constant value="12:3-12:6"/>
		<constant value="12:9-12:10"/>
		<constant value="12:3-12:10"/>
		<constant value="8:3-12:10"/>
		<constant value="13:3-13:6"/>
		<constant value="13:10-13:11"/>
		<constant value="13:3-13:11"/>
		<constant value="8:3-13:11"/>
		<constant value="18:3-18:8"/>
		<constant value="18:11-18:12"/>
		<constant value="18:3-18:12"/>
		<constant value="8:3-18:12"/>
		<constant value="20:10-22:6"/>
		<constant value="__applymodel"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="something"/>
		<constant value="21:14-21:25"/>
		<constant value="21:6-21:25"/>
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
			<pushi arg="19"/>
			<pushi arg="19"/>
			<call arg="50"/>
			<pushi arg="19"/>
			<pushd arg="51"/>
			<call arg="50"/>
			<call arg="52"/>
			<pushd arg="51"/>
			<pushi arg="19"/>
			<call arg="50"/>
			<call arg="52"/>
			<pushd arg="51"/>
			<pushi arg="19"/>
			<call arg="53"/>
			<call arg="52"/>
			<push arg="54"/>
			<pushi arg="19"/>
			<call arg="50"/>
			<call arg="52"/>
			<push arg="54"/>
			<pushi arg="19"/>
			<call arg="55"/>
			<call arg="52"/>
			<pushf/>
			<pushi arg="19"/>
			<call arg="50"/>
			<call arg="52"/>
			<call arg="56"/>
			<if arg="57"/>
			<getasm/>
			<get arg="1"/>
			<push arg="58"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="59"/>
			<dup/>
			<push arg="60"/>
			<load arg="19"/>
			<pcall arg="61"/>
			<dup/>
			<push arg="62"/>
			<push arg="46"/>
			<push arg="63"/>
			<new/>
			<pcall arg="64"/>
			<pusht/>
			<pcall arg="65"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="66" begin="7" end="7"/>
			<lne id="67" begin="8" end="8"/>
			<lne id="68" begin="7" end="9"/>
			<lne id="69" begin="10" end="10"/>
			<lne id="70" begin="11" end="11"/>
			<lne id="71" begin="10" end="12"/>
			<lne id="72" begin="7" end="13"/>
			<lne id="73" begin="14" end="14"/>
			<lne id="74" begin="15" end="15"/>
			<lne id="75" begin="14" end="16"/>
			<lne id="76" begin="7" end="17"/>
			<lne id="77" begin="18" end="18"/>
			<lne id="78" begin="19" end="19"/>
			<lne id="79" begin="18" end="20"/>
			<lne id="80" begin="7" end="21"/>
			<lne id="81" begin="22" end="22"/>
			<lne id="82" begin="23" end="23"/>
			<lne id="83" begin="22" end="24"/>
			<lne id="84" begin="7" end="25"/>
			<lne id="85" begin="26" end="26"/>
			<lne id="86" begin="27" end="27"/>
			<lne id="87" begin="26" end="28"/>
			<lne id="88" begin="7" end="29"/>
			<lne id="89" begin="30" end="30"/>
			<lne id="90" begin="31" end="31"/>
			<lne id="91" begin="30" end="32"/>
			<lne id="92" begin="7" end="33"/>
			<lne id="93" begin="48" end="53"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="60" begin="6" end="55"/>
			<lve slot="0" name="17" begin="0" end="56"/>
		</localvariabletable>
	</operation>
	<operation name="94">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="95"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="60"/>
			<call arg="96"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="62"/>
			<call arg="97"/>
			<store arg="98"/>
			<load arg="98"/>
			<dup/>
			<getasm/>
			<push arg="99"/>
			<call arg="30"/>
			<set arg="38"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="100" begin="11" end="11"/>
			<lne id="101" begin="9" end="13"/>
			<lne id="93" begin="8" end="14"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="62" begin="7" end="14"/>
			<lve slot="2" name="60" begin="3" end="14"/>
			<lve slot="0" name="17" begin="0" end="14"/>
			<lve slot="1" name="102" begin="0" end="14"/>
		</localvariabletable>
	</operation>
</asm>
