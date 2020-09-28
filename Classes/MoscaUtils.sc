MoscaUtils { // virtual class holding constants for Mosca related classes
	classvar cart = #[
		0.850650808352E+00,
		0,
		-0.525731112119E+00,
		0.525731112119E+00,
		-0.850650808352E+00,
		0.000000000000E+00,
		0,
		-0.525731112119E+00,
		0.850650808352E+00,
		0.850650808352E+00,
		0,
		0.525731112119E+00,
		-0.525731112119E+00,
		-0.850650808352E+00,
		0,
		0,
		0.525731112119E+00,
		-0.850650808352E+00,
		-0.850650808352E+00,
		0,
		-0.525731112119E+00,
		-0.525731112119E+00,
		0.850650808352E+00,
		0,
		0,
		0.525731112119E+00,
		0.850650808352E+00,
		-0.850650808352E+00,
		0,
		0.525731112119E+00,
		0.525731112119E+00,
		0.850650808352E+00,
		0,
		0,
		-0.525731112119E+00,
		-0.850650808352E+00
	];

	*plim { ^1.2; } // distance limit from origin where processes continue to run

	*halfPi { ^1.5707963267949; }

	*rad2deg { ^57.295779513082; }

	*fftSize { ^2048; }

	*n2f { | sig | ^FoaEncoderMatrix.newHoa1(); }

	*b2a { | sig | ^FoaDecoderMatrix.newBtoA(); }

	*a2b { | sig | ^FoaEncoderMatrix.newAtoB(); }

	*f2n { | sig | ^FoaDecoderMatrix.newHoa1(); }

	*fourOrNine { | order |
		if (order > 1) {
			^9;
		} {
			^4;
		};
	}

	*bfOrFmh { | order |
		if (order > 1) {
			^FMHEncode1;
		} {
			^BFEncode1;
		};
	}

	// a-12 decoder matrix

	*soa_a12_decoder_matrix {
		^Matrix.with([
			[ 0.11785113, 0.212662702, 0, -0.131432778, -0.0355875819, -0.279508497, 0,
				0.226127124, 0 ],
			[ 0.11785113, 0.131432778, -0.212662702, 0, -0.208333333, 0, 0, -0.139754249,
				-0.279508497 ],
			[ 0.11785113, 0, -0.131432778, 0.212662702, 0.243920915, 0, -0.279508497,
				-0.0863728757, 0 ],
			[ 0.11785113, 0.212662702, 0, 0.131432778, -0.0355875819, 0.279508497, 0,
				0.226127124, 0 ],
			[ 0.11785113, -0.131432778, -0.212662702, 0, -0.208333333, 0, 0, -0.139754249,
				0.279508497 ],
			[ 0.11785113, 0, 0.131432778, -0.212662702, 0.243920915, 0, -0.279508497,
				-0.0863728757, 0 ],
			[ 0.11785113, -0.212662702, 0, -0.131432778, -0.0355875819, 0.279508497, 0,
				0.226127124, 0 ],
			[ 0.11785113, -0.131432778, 0.212662702, 0, -0.208333333, 0, 0, -0.139754249,
				-0.279508497 ],
			[ 0.11785113, 0, 0.131432778, 0.212662702, 0.243920915, 0, 0.279508497,
				-0.0863728757, 0 ],
			[ 0.11785113, -0.212662702, 0, 0.131432778, -0.0355875819, -0.279508497, 0,
				0.226127124, 0 ],
			[ 0.11785113, 0.131432778, 0.212662702, 0, -0.208333333, 0, 0, -0.139754249,
				0.279508497 ],
			[ 0.11785113, 0, -0.131432778, -0.212662702, 0.243920915, 0, 0.279508497,
				-0.0863728757, 0 ],
		]);
	}

	// a-12 encoder matrix

	*soa_a12_encoder_matrix {
		^Matrix.with([
			[ 0.707106781, 0.707106781, 0.707106781, 0.707106781, 0.707106781,
				0.707106781,0.707106781,
				0.707106781, 0.707106781, 0.707106781, 0.707106781, 0.707106781 ],
			[ 0.850650808, 0.525731112, 0, 0.850650808, -0.525731112, 0, -0.850650808,
				-0.525731112, 0,
				-0.850650808, 0.525731112, 0 ],
			[ 0, -0.850650808, -0.525731112, 0, -0.850650808, 0.525731112, 0, 0.850650808,
				0.525731112,
				0, 0.850650808, -0.525731112 ],
			[ -0.525731112, 0, 0.850650808, 0.525731112, 0, -0.850650808, -0.525731112, 0,
				0.850650808,
				0.525731112, 0, -0.850650808 ],
			[ -0.0854101966, -0.5, 0.585410197, -0.0854101966, -0.5, 0.585410197,
				-0.0854101966, -0.5,
				0.585410197, -0.0854101966, -0.5, 0.585410197 ],
			[ -0.894427191, 0, 0, 0.894427191, 0, 0, 0.894427191, 0, 0, -0.894427191,
				0, 0 ],
			[ 0, 0, -0.894427191, 0, 0, -0.894427191, 0, 0, 0.894427191, 0, 0,
				0.894427191 ],
			[ 0.723606798, -0.447213596, -0.276393202, 0.723606798, -0.447213596,
				-0.276393202,
				0.723606798, -0.447213596, -0.276393202, 0.723606798, -0.447213596,
				-0.276393202 ],
			[ 0, -0.894427191, 0, 0, 0.894427191, 0, 0, -0.894427191, 0, 0, 0.894427191,
				0 ],
		]);
	}

	// 1st-order FuMa-MaxN A-format decoder

	*foa_a12_decoder_matrix {
		var spher;

		// convert to angles -- use these directions
		spher = cart.collect({ | cart, i |
			cart.asCartesian.asSpherical.angles;
		});

		^FoaEncoderMatrix.newDirections(spher).matrix.pseudoInverse;
	}

	// 1st-order FuMa-MaxN A-format decoder

	*foa_n3d_encoder {

		^4.collect({ | i |
			var sphe = cart.clump(3)[i].asCartesian.asSpherical;
			HOASphericalHarmonics.coefN3D(1, sphe.theta(), sphe.phi());
		});
	}

	// 1st-order FuMa-MaxN A-format decoder

	*soa_n3d_encoder {

		^cart.clump(3).collect({ | cart |
			var sphe = cart.asCartesian.asSpherical;
			HOASphericalHarmonics.coefN3D(1, sphe.theta(), sphe.phi());
		});
	}
}